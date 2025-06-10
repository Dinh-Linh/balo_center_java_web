package com.example.balo_center.service.user.impl;

import com.example.balo_center.domain.dto.response.PagingAndSortingParams;
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
        Page<ProductData> productDataPage = productUserRepository.getProductDataByPrice(price, buildPageable(pagingAndSortingParams));
        return productDataPage.map(productMapper::toProductResponse);
    }

    @Override
    public Page<ProductResponse> filterByBrand(String brandName, PagingAndSortingParams pagingAndSortingParams) {
        Page<ProductData> productDataPage = productUserRepository.getProductDataByBrandName(brandName, buildPageable(pagingAndSortingParams));
        return productDataPage.map(productMapper::toProductResponse);
    }

    @Override
    public Page<ProductResponse> searchProductContainIgnoreCase(String name, PagingAndSortingParams pagingAndSortingParams) {
        Page<ProductData> productDataPage = productUserRepository.searchProductByNameContainingIgnoreCase(name, buildPageable(pagingAndSortingParams));
        return productDataPage.map(productMapper::toProductResponse);
    }

    @Override
    public Page<ProductResponse> getAllProduct(PagingAndSortingParams pagingAndSortingParams) {
        Page<ProductData> productDataPage = productUserRepository.getAllProduct(buildPageable(pagingAndSortingParams));
        return productDataPage.map(productMapper::toProductResponse);
    }

    @Override
    public Page<String> getAllBrand(PagingAndSortingParams pagingAndSortingParams) {
        Pageable pageable = PageRequest.of(pagingAndSortingParams.page(), pagingAndSortingParams.size(), Sort.by("brandName"));
        return productUserRepository.getAllBrandName(pageable);
    }

    private Pageable buildPageable(PagingAndSortingParams pagingAndSortingParams) {
        Sort orders = pagingAndSortingParams.sortDir().equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(pagingAndSortingParams.sortBy()) : Sort.by(pagingAndSortingParams.sortBy()).descending();
        return PageRequest.of(pagingAndSortingParams.page(), pagingAndSortingParams.size(), orders);
    }
}
