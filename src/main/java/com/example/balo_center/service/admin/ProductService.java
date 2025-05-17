package com.example.balo_center.service.admin;

import com.example.balo_center.domain.dto.response.ProductFormResponseDTO;

import java.util.List;

public interface ProductService {
    public List<ProductFormResponseDTO> getAllProduct();
    public void saveProduct(ProductFormResponseDTO form);

    public ProductFormResponseDTO getProductById(String id);

    public void updateProduct(String id, ProductFormResponseDTO updatedProduct);

    public void deleteProduct(String id);
}
