package com.example.balo_center.service.admin.impl;

import com.example.balo_center.domain.builder.ProductBuilder;
import com.example.balo_center.domain.dto.response.ProductFormResponseDTO;
import com.example.balo_center.domain.entity.Branch;
import com.example.balo_center.domain.entity.Category;
import com.example.balo_center.domain.entity.Product;
import com.example.balo_center.repository.BranchRepo;
import com.example.balo_center.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFactory {
    private final CategoryRepository categoryRepository;
    private final BranchRepo branchRepo;

    public Product createProduct(ProductFormResponseDTO formResponseDTO) {
        return new ProductBuilder()
                .withBasicInfo(formResponseDTO)
                .withCategory(getCategoryOrCreate(formResponseDTO.categoryName()))
                .withBranch(getBranchOrCreate(formResponseDTO.branchName()))
                .build();
    }

    private Category getCategoryOrCreate(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName)
                .orElseGet(
                        () -> {
                            Category category = new Category();
                            category.setCategoryName(categoryName);
                            return categoryRepository.save(category);
                        }
                );
    }

    private Branch getBranchOrCreate(String branchName) {
        return branchRepo.findByBranchName(branchName)
                .orElseGet(() -> {
                    Branch branch = new Branch();
                    branch.setBranchName(branchName);
                    return branchRepo.save(branch);
                });
    }
}
