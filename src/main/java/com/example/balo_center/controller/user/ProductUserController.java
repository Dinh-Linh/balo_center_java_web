package com.example.balo_center.controller.user;

import com.example.balo_center.domain.dto.response.ApiResponse;
import com.example.balo_center.domain.dto.response.PagingAndSortingParams;
import com.example.balo_center.domain.dto.response.ProductResponse;
import com.example.balo_center.service.user.ProductUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductUserController {
    private final ProductUserService productUserService;

    @GetMapping("/products")
    public ApiResponse<Map<String, Object>> getAllProduct(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") String sortDir,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        Page<ProductResponse> productResponses = productUserService.getAllProduct(
                PagingAndSortingParams.builder()
                        .page(page)
                        .size(size)
                        .sortBy(sortBy)
                        .sortDir(sortDir)
                        .build()
        );

        return new ApiResponse<>(HttpStatus.OK.value(), "Product got successfully", buildResponse(productResponses));
    }

    @GetMapping("/products/brands")
    public ApiResponse<Map<String, Object>> getAllBrand(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<String> brandPage = productUserService.getAllBrand(PagingAndSortingParams.builder()
                .page(page)
                .size(size)
                .build()
        );

        return new ApiResponse<>(HttpStatus.OK.value(), "Product name fetched successfully", buildResponse(brandPage));
    }

    @GetMapping("/products/filter/price/{price}")
    public ApiResponse<Map<String, Object>> filterByPrice(
            @PathVariable String price,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") String sortDir,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        Page<ProductResponse> productResponses = productUserService.filterByPrice(price, PagingAndSortingParams.builder()
                .page(page)
                .size(size)
                .sortBy(sortBy)
                .sortDir(sortDir)
                .build()
        );

        return new ApiResponse<>(HttpStatus.OK.value(), "Product price filtered successfully", buildResponse(productResponses));
    }

    @GetMapping("/products/filter/brand/{brandName}")
    public ApiResponse<Map<String, Object>> filterByBrandName(
            @PathVariable String brandName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") String sortDir,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        Page<ProductResponse> productResponses = productUserService.filterByBrand(brandName, PagingAndSortingParams.builder()
                .page(page)
                .size(size)
                .sortBy(sortBy)
                .sortDir(sortDir)
                .build()
        );

        return new ApiResponse<>(HttpStatus.OK.value(), "Product filtered Successfully", buildResponse(productResponses));
    }

    @GetMapping("/products/{id}")
    public ApiResponse<ProductResponse> getProductById(@PathVariable Long id) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Product fetched successfully", productUserService.getProductById(id));
    }

    private <T> Map<String, Object> buildResponse(Page<T> page) {
        Map<String, Object> response = new HashMap<>();
        response.put("content", page.getContent());
        response.put("currentPage", page.getNumber());
        response.put("totalItems", page.getTotalElements());
        response.put("totalPages", page.getTotalPages());
        response.put("pageSize", page.getSize());
        response.put("isFirst", page.isFirst());
        response.put("isLast", page.isLast());
        return response;
    }
}