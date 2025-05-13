package com.example.balo_center.module.service.admin.impl;

import com.example.balo_center.domain.dto.ProductDTO;
import com.example.balo_center.domain.entity.repo.ProductRepo;
import com.example.balo_center.module.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<ProductDTO> getAllProduct() {
        return productRepo.findAllProduct();
    }
}
