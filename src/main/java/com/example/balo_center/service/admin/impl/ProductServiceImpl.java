package com.example.balo_center.service.admin.impl;

import com.example.balo_center.domain.dto.response.ProductFormResponseDTO;
import com.example.balo_center.domain.entity.ProductSell;
import com.example.balo_center.repository.BranchRepo;
import com.example.balo_center.repository.CategoryRepository;
import com.example.balo_center.repository.ProductRepo;
import com.example.balo_center.service.admin.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepository categoryRepository;
    private final BranchRepo branchRepo;
    private final ProductUpdateStrategy productUpdateStrategy;
    private final ProductFactory productFactory;

    @Override
    public List<ProductFormResponseDTO> getAllProduct() {
        return productRepo.findAllProduct();
    }

    @Override
    public ProductFormResponseDTO getProductById(String id) {
        return productRepo.findProductById(id);
    }

    @Override
    public void updateProduct(String id, ProductFormResponseDTO updatedProduct) {
        ProductSell existingProductSell = productRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        productUpdateStrategy.update(existingProductSell, updatedProduct);
        productRepo.save(existingProductSell);
    }

    @Override
    public void saveProduct(ProductFormResponseDTO form) {
        ProductSell productSell = productFactory.createProduct(form);
        productRepo.save(productSell);
    }

    @Override
    public void deleteProduct(String id) {
        productRepo.deleteById(id);
    }
}
