package com.example.balo_center.module.service.admin;

import com.example.balo_center.domain.dto.ProductFormDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public Page<ProductFormDTO> getAllProduct(int page, int size, String searchName, String brand, String sortBy);

    List<Map<String, String>> importProductsFromExcel(MultipartFile file) throws Exception;
    public void saveProduct(ProductFormDTO form);

    public ProductFormDTO getProductById(String id);

    public void updateProduct(String id, ProductFormDTO updatedProduct);

    public void deleteProduct(String id);
}
