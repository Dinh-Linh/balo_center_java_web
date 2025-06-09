package com.example.balo_center.module.service.admin.impl;

import com.example.balo_center.domain.dto.ProductFormDTO;
import com.example.balo_center.domain.entity.Branch;
import com.example.balo_center.domain.entity.Category;
import com.example.balo_center.domain.entity.Product;
import com.example.balo_center.domain.repo.BranchRepo;
import com.example.balo_center.domain.repo.CategoryRepo;
import com.example.balo_center.domain.repo.ProductRepo;
import com.example.balo_center.module.service.admin.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    private final CategoryRepo categoryRepo;

    private final BranchRepo branchRepo;

    @Override
    public Page<ProductFormDTO> getAllProduct(int page, int size, String searchName, String brand, String category, String sortBy) {
        Pageable pageable = PageRequest.of(page, size);

        if (sortBy != null && !sortBy.isEmpty()) {
            Sort sort = switch (sortBy) {
                case "priceAsc" -> Sort.by(Sort.Direction.ASC, "price");
                case "priceDesc" -> Sort.by(Sort.Direction.DESC, "price");
                case "soldAsc" -> Sort.by(Sort.Direction.ASC, "sold");
                case "soldDesc" -> Sort.by(Sort.Direction.DESC, "sold");
                default -> Sort.unsorted();
            };
            pageable = PageRequest.of(page, size, sort);
        }

        return productRepo.findAllProduct(searchName, brand, category, pageable);
    }

    @Override
    public void saveProduct(ProductFormDTO form) {
        Product product = new Product();
        String[] words = form.getDetailsDesc().trim().split("\\s+");
        product.setProductName(form.getProductName());
        product.setQuality(form.getQuantity());
        product.setSold(0);
        product.setPrice(form.getPrice());
        product.setProductDetailDesc(form.getDetailsDesc());
        product.setProductShortDesc(words.length <= 5 ? form.getDetailsDesc() : String.join(" ", Arrays.copyOfRange(words, 0, 10)) + "...");
        product.setImage(form.getImageLinks());

        Category category = categoryRepo.findByCategoryName(form.getCategoryName());
        if (category == null) {
            category = new Category();
            category.setCategoryName(form.getCategoryName());
            categoryRepo.save(category);
        }
        product.setCategory(category);

        Branch branch = branchRepo.findByBranchName(form.getBranchName());
        if (branch == null) {
            branch = new Branch();
            branch.setBranchName(form.getBranchName());
            branchRepo.save(branch);
        }
        product.setBranch(branch);
        productRepo.save(product);
    }

    @Override
    public ProductFormDTO getProductById(String id) {
        ProductFormDTO product = productRepo.findProductById(id);
        if (product != null) {
            List<String> images = productRepo.findProductImages(id);
            product.setImageLinks(images);
        }
        return product;
    }

    @Override
    public void updateProduct(String id, ProductFormDTO updatedProduct) {
        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        if (updatedProduct.getProductName() != null) {
            existingProduct.setProductName(updatedProduct.getProductName());
        }
        if (updatedProduct.getSold() != null) {
            existingProduct.setSold(updatedProduct.getSold());
        }
        if (updatedProduct.getPrice() != null) {
            existingProduct.setPrice(updatedProduct.getPrice());
        }
        if (updatedProduct.getQuantity() != null) {
            existingProduct.setQuality(updatedProduct.getQuantity());
        }
        if (updatedProduct.getDetailsDesc() != null) {
            existingProduct.setProductDetailDesc(updatedProduct.getDetailsDesc());
            String[] words = updatedProduct.getDetailsDesc().trim().split("\\s+");
            existingProduct.setProductShortDesc(words.length <= 5 ? updatedProduct.getDetailsDesc() : String.join(" ", Arrays.copyOfRange(words, 0, 10)) + "...");
        }
        if (updatedProduct.getCategoryName() != null) {
            Category category = categoryRepo.findByCategoryName(updatedProduct.getCategoryName());
            if (category == null) {
                category = new Category();
                category.setCategoryName(updatedProduct.getCategoryName());
                categoryRepo.save(category);
            }
            existingProduct.setCategory(category);
        }
        if (updatedProduct.getBranchName() != null) {
            Branch branch = branchRepo.findByBranchName(updatedProduct.getBranchName());
            if (branch == null) {
                branch = new Branch();
                branch.setBranchName(updatedProduct.getBranchName());
                branchRepo.save(branch);
            }
            existingProduct.setBranch(branch);
        }

        productRepo.save(existingProduct);
    }

    @Override
    public void deleteProduct(String id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Map<String, String>> importProductsFromExcel(MultipartFile file) throws Exception {
        List<Map<String, String>> results = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);

            // Validate header row
            validateHeaderRow(headerRow);

            // Process data rows
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                try {
                    Product product = createProductFromRow(row);
                    products.add(product);
                    results.add(createSuccessResult(product));
                } catch (Exception e) {
                    results.add(createErrorResult(row.getRowNum(), e.getMessage()));
                }
            }

            // Save all valid products
            if (!products.isEmpty()) {
                productRepo.saveAll(products);
            }

        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi đọc file Excel: " + e.getMessage());
        }

        return results;
    }

    private void validateHeaderRow(Row headerRow) {
        if (headerRow == null) {
            throw new RuntimeException("File Excel không có header");
        }

        String[] expectedHeaders = {
                "Tên sản phẩm",
                "Giá",
                "Mô tả chi tiết",
                "Số lượng",
                "Danh mục",
                "Thương hiệu",
                "Số lượng đã bán",
                "Hình ảnh"
        };

        for (int i = 0; i < expectedHeaders.length; i++) {
            Cell cell = headerRow.getCell(i);
            if (cell == null || !expectedHeaders[i].equals(cell.getStringCellValue())) {
                throw new RuntimeException("Header không hợp lệ. Header phải là: " + String.join(", ", expectedHeaders));
            }
        }
    }

    private Product createProductFromRow(Row row) {
        Product product = new Product();

        // Tên sản phẩm
        Cell nameCell = row.getCell(0);
        if (nameCell == null || nameCell.getStringCellValue().trim().isEmpty()) {
            throw new RuntimeException("Tên sản phẩm không được để trống");
        }
        product.setProductName(nameCell.getStringCellValue().trim());

        // Giá
        Cell priceCell = row.getCell(1);
        if (priceCell == null) {
            throw new RuntimeException("Giá không được để trống");
        }
        try {
            product.setPrice(priceCell.getNumericCellValue());
        } catch (Exception e) {
            throw new RuntimeException("Giá không hợp lệ");
        }

        // Mô tả chi tiết
        Cell descriptionCell = row.getCell(2);
        if (descriptionCell != null) {
            String detailDesc = descriptionCell.getStringCellValue().trim();
            product.setProductDetailDesc(detailDesc);
            // Tạo mô tả ngắn từ 10 từ đầu tiên
            String[] words = detailDesc.split("\\s+");
            product.setProductShortDesc(words.length <= 10 ? detailDesc : String.join(" ", Arrays.copyOfRange(words, 0, 10)) + "...");
        }

        // Số lượng
        Cell quantityCell = row.getCell(3);
        if (quantityCell == null) {
            throw new RuntimeException("Số lượng không được để trống");
        }
        try {
            product.setQuality((int) quantityCell.getNumericCellValue());
        } catch (Exception e) {
            throw new RuntimeException("Số lượng không hợp lệ");
        }

        // Danh mục
        Cell categoryCell = row.getCell(4);
        if (categoryCell == null || categoryCell.getStringCellValue().trim().isEmpty()) {
            throw new RuntimeException("Danh mục không được để trống");
        }
        String categoryName = categoryCell.getStringCellValue().trim();
        Category category = categoryRepo.findByCategoryName(categoryName);
        if (category == null) {
            category = new Category();
            category.setCategoryName(categoryName);
            categoryRepo.save(category);
        }
        product.setCategory(category);

        // Thương hiệu
        Cell branchCell = row.getCell(5);
        if (branchCell == null || branchCell.getStringCellValue().trim().isEmpty()) {
            throw new RuntimeException("Thương hiệu không được để trống");
        }
        String branchName = branchCell.getStringCellValue().trim();
        Branch branch = branchRepo.findByBranchName(branchName);
        if (branch == null) {
            branch = new Branch();
            branch.setBranchName(branchName);
            branchRepo.save(branch);
        }
        product.setBranch(branch);

        // Số lượng đã bán
        Cell soldCell = row.getCell(6);
        if (soldCell != null) {
            try {
                product.setSold((int) soldCell.getNumericCellValue());
            } catch (Exception e) {
                throw new RuntimeException("Số lượng đã bán không hợp lệ");
            }
        } else {
            product.setSold(0);
        }

        // Hình ảnh
        Cell imagesCell = row.getCell(7);
        if (imagesCell != null) {
            String imagesStr = imagesCell.getStringCellValue().trim();
            if (!imagesStr.isEmpty()) {
                List<String> images = Arrays.asList(imagesStr.split(","));
                product.setImage(images);
            }
        }

        return product;
    }

    private Map<String, String> createSuccessResult(Product product) {
        Map<String, String> result = new HashMap<>();
        result.put("status", "success");
        result.put("message", "Thêm sản phẩm thành công: " + product.getProductName());
        return result;
    }

    private Map<String, String> createErrorResult(int rowNum, String errorMessage) {
        Map<String, String> result = new HashMap<>();
        result.put("status", "error");
        result.put("message", "Dòng " + (rowNum + 1) + ": " + errorMessage);
        return result;
    }

    @Override
    public List<Map<String, String>> getProductSuggestions(String term) {
        List<Product> products = productRepo.findTop10ByProductNameContainingIgnoreCase(term);
        return products.stream()
                .map(product -> {
                    Map<String, String> suggestion = new HashMap<>();
                    suggestion.put("id", product.getId());
                    suggestion.put("label", product.getProductName());
                    suggestion.put("value", product.getProductName());
                    suggestion.put("category", product.getCategory().getCategoryName());
                    suggestion.put("brand", product.getBranch().getBranchName());
                    suggestion.put("price", String.valueOf(product.getPrice()));
                    return suggestion;
                })
                .collect(Collectors.toList());
    }
}