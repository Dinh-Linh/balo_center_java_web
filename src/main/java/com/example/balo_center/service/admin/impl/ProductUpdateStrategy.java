package com.example.balo_center.service.admin.impl;

import com.example.balo_center.domain.dto.response.ProductFormResponseDTO;
import com.example.balo_center.domain.entity.Branch;
import com.example.balo_center.domain.entity.Category;
import com.example.balo_center.domain.entity.ProductSell;
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

    public void update(ProductSell existingProductSell, ProductFormResponseDTO updatedProduct) {
        updateBasicInfo(existingProductSell, updatedProduct);
        updateCategory(existingProductSell, updatedProduct);
        updateBranch(existingProductSell, updatedProduct);
    }

    private void updateBasicInfo(ProductSell existingProductSell, ProductFormResponseDTO updated) {
        Optional.ofNullable(updated.productName()).ifPresent(existingProductSell::setProductName);
        Optional.ofNullable(updated.sold()).ifPresent(existingProductSell::setSold);
        Optional.ofNullable(updated.price()).ifPresent(existingProductSell::setPrice);
        Optional.ofNullable(updated.quantity()).ifPresent(existingProductSell::setQuality);
        Optional.ofNullable(updated.detailsDesc()).ifPresent(desc -> updateDescriptions(existingProductSell, desc));
    }

    private void updateDescriptions(ProductSell productSell, String detailsDesc) {
        productSell.setProductDetailDesc(detailsDesc);
        String[] words = detailsDesc.trim().split("\\s+");
        productSell.setProductShortDesc(words.length <= 5 ? detailsDesc : String.join(" ", Arrays.copyOfRange(words, 0, 10)) + "...");
    }

    private void updateCategory(ProductSell productSell, ProductFormResponseDTO updated) {
        Optional.ofNullable(updated.categoryName()).ifPresent(categoryName -> {
            Category category = categoryRepository.findByCategoryName(categoryName).orElseGet(() -> {
                Category newCategory = new Category();
                newCategory.setCategoryName(categoryName);
                return categoryRepository.save(newCategory);
            });
            productSell.setCategory(category);
        });
    }

    private void updateBranch(ProductSell productSell, ProductFormResponseDTO updated) {
        Optional.ofNullable(updated.branchName()).ifPresent(branchName -> {
            Branch branch = branchRepo.findByBranchName(branchName).orElseGet(() -> {
                Branch newBranch = new Branch();
                newBranch.setBranchName(branchName);
                return branchRepo.save(newBranch);
            });
            productSell.setBranch(branch);
        });
    }
}