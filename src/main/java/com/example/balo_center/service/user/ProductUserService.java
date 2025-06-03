package com.example.balo_center.service.user;

import com.example.balo_center.domain.dto.response.PagingAndSortingParams;
import com.example.balo_center.domain.dto.response.ProductResponse;
import org.springframework.data.domain.Page;

public interface ProductUserService {
    Page<ProductResponse> getAllProduct(PagingAndSortingParams pagingAndSortingParams);

    Page<String> getAllBrand(PagingAndSortingParams pagingAndSortingParams);

    Page<ProductResponse> filterByPrice(String price, PagingAndSortingParams pagingAndSortingParams);

    Page<ProductResponse> filterByBrand(String brandName, PagingAndSortingParams pagingAndSortingParams);

    ProductResponse getProductById(Long id);
}