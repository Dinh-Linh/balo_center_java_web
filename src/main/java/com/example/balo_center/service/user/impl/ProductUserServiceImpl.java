package com.example.balo_center.service.user.impl;

import com.example.balo_center.controller.user.PagingAndSortingParams;
import com.example.balo_center.domain.dto.response.ProductResponse;
import com.example.balo_center.domain.entity.ProductData;
import com.example.balo_center.domain.mapper.ProductMapper;
import com.example.balo_center.exception.ResourceNotFoundException;
import com.example.balo_center.repository.ProductUserRepository;
import com.example.balo_center.service.user.ProductUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductUserServiceImpl implements ProductUserService {
    private final ProductUserRepository productUserRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse getProductById(Long id) {
        ProductData productData = productUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return productMapper.toProductResponse(productData);
    }

    @Override
    public Page<ProductResponse> filterByPrice(String price, PagingAndSortingParams pagingAndSortingParams) {
        Sort orders = pagingAndSortingParams.sortDir().equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(pagingAndSortingParams.sortBy()) : Sort.by(pagingAndSortingParams.sortBy()).descending();
        Pageable pageable = PageRequest.of(pagingAndSortingParams.page(), pagingAndSortingParams.size(), orders);
        Page<ProductData> productDataPage = productUserRepository.getProductDataByPrice(price, pageable);
        return productDataPage.map(productMapper::toProductResponse);
    }

    @Override
    public Page<ProductResponse> filterByBrand(String brandName, PagingAndSortingParams pagingAndSortingParams) {
        List<ProductResponse> productResponses = getAllProduct();
        return productResponses.stream().filter(productResponse -> productResponse.brandName().equals(brandName)).toList();
    }

    @Override
    public Page<ProductResponse> getAllProduct(PagingAndSortingParams pagingAndSortingParams) {
        Sort sortProduct = pagingAndSortingParams.sortDir().equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(pagingAndSortingParams.sortBy()) : Sort.by(pagingAndSortingParams.sortBy()).descending();
        Pageable pageable = PageRequest.of(pagingAndSortingParams.page(), pagingAndSortingParams.size(), sortProduct);
        Page<ProductData> productDataPage = productUserRepository.getAllProduct(pageable);
        return productDataPage.map(productMapper::toProductResponse);
    }

    @Override
    public Page<String> getAllBrand(PagingAndSortingParams pagingAndSortingParams) {
        Pageable pageable = PageRequest.of(pagingAndSortingParams.page(), pagingAndSortingParams.size(), Sort.by("brandName"));
        return productUserRepository.getAllBrandName(pageable);
    }
}
