package com.example.balo_center.module.service.admin;

import com.example.balo_center.domain.dto.ProductDTO;
import com.example.balo_center.domain.dto.ProductFormDTO;
import com.example.balo_center.domain.entity.Product;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> getAllProduct();
    public void saveProduct(ProductFormDTO form);

    public ProductFormDTO getProductById(String id);

    public void updateProduct(String id, ProductFormDTO updatedProduct);

    public void deleteProduct(String id);
}
