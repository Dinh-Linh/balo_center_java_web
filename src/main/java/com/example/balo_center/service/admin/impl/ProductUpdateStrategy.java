package com.example.balo_center.service.admin.impl;

import com.example.balo_center.domain.dto.response.ProductFormResponseDTO;
import com.example.balo_center.domain.entity.Branch;
import com.example.balo_center.domain.entity.Category;
import com.example.balo_center.domain.entity.Product;
import com.example.balo_center.repository.BranchRepo;
import com.example.balo_center.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class ProductUpdateStrategy {
    private final CategoryRepository categoryRepository;
    private final BranchRepo branchRepo;

    public void update(Product existingProduct, ProductFormResponseDTO updatedProduct) {
        updateBasicInfo(existingProduct, updatedProduct);
        updateCategory(existingProduct, updatedProduct);
        updateBranch(existingProduct, updatedProduct);
    }

    private void updateBasicInfo(Product existingProduct, ProductFormResponseDTO updated) {
        Optional.ofNullable(updated.productName()).ifPresent(existingProduct::setProductName);
        Optional.ofNullable(updated.sold()).ifPresent(existingProduct::setSold);
        Optional.ofNullable(updated.price()).ifPresent(existingProduct::setPrice);
        Optional.ofNullable(updated.quantity()).ifPresent(existingProduct::setQuality);
        Optional.ofNullable(updated.detailsDesc()).ifPresent(desc -> updateDescriptions(existingProduct, desc));
    }

    private void updateDescriptions(Product product, String detailsDesc) {
        product.setProductDetailDesc(detailsDesc);
        String[] words = detailsDesc.trim().split("\\s+");
        product.setProductShortDesc(words.length <= 5 ? detailsDesc : String.join(" ", Arrays.copyOfRange(words, 0, 10)) + "...");
    }

    private void updateCategory(Product product, ProductFormResponseDTO updated) {
        Optional.ofNullable(updated.categoryName()).ifPresent(categoryName -> {
            Category category = categoryRepository.findByCategoryName(categoryName).orElseGet(() -> {
                Category newCategory = new Category();
                newCategory.setCategoryName(categoryName);
                return categoryRepository.save(newCategory);
            });
            product.setCategory(category);
        });
    }

    private void updateBranch(Product product, ProductFormResponseDTO updated) {
        Optional.ofNullable(updated.branchName()).ifPresent(branchName -> {
            Branch branch = branchRepo.findByBranchName(branchName).orElseGet(() -> {
                Branch newBranch = new Branch();
                newBranch.setBranchName(branchName);
                return branchRepo.save(newBranch);
            });
            product.setBranch(branch);
        });
    }
}