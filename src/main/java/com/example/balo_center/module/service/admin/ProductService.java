package com.example.balo_center.module.service.admin;

import com.example.balo_center.domain.dto.ProductFormDTO;

import java.util.List;

public interface ProductService {
    public List<ProductFormDTO> getAllProduct();
    public void saveProduct(ProductFormDTO form);

    public ProductFormDTO getProductById(String id);

    public void updateProduct(String id, ProductFormDTO updatedProduct);

    public void deleteProduct(String id);
}
