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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private BranchRepo branchRepo;

    @Override
    public Page<ProductFormDTO> getAllProduct(int page, int size, String searchName, String brand, String sortBy) {
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
        
        return productRepo.findAllProduct(searchName, brand, pageable);
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
}
