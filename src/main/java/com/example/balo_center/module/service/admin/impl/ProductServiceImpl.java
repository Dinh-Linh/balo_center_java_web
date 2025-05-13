package com.example.balo_center.module.service.admin.impl;

import com.example.balo_center.domain.dto.ProductDTO;
import com.example.balo_center.domain.dto.ProductFormDTO;
import com.example.balo_center.domain.entity.Branch;
import com.example.balo_center.domain.entity.Category;
import com.example.balo_center.domain.entity.Product;
import com.example.balo_center.domain.entity.repo.BranchRepo;
import com.example.balo_center.domain.entity.repo.CategoryRepo;
import com.example.balo_center.domain.entity.repo.ProductRepo;
import com.example.balo_center.module.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ProductDTO> getAllProduct() {
        return productRepo.findAllProduct();
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
        return product;
    }
}
