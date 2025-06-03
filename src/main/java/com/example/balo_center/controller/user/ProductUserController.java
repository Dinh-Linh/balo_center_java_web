package com.example.balo_center.controller.user;

import com.example.balo_center.domain.dto.response.ApiResponse;
import com.example.balo_center.domain.dto.response.ProductResponse;
import com.example.balo_center.service.user.ProductUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductUserController {
    private final ProductUserService productUserService;

    @GetMapping("/products")
    public ApiResponse<List<ProductResponse>> getAllProduct() {
        return new ApiResponse<>(HttpStatus.OK.value(), "Product got successfully", productUserService.getAllProduct());
    }

    @GetMapping("/products/brands")
    public ApiResponse<Map<String, Object>> getAllBrand(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<String> brandPage = productUserService.getAllBrand(page, size);

        Map<String, Object> response = new HashMap<>();
        response.put("brandName", brandPage.getContent());
        response.put("currentPage", brandPage.getNumber());
        response.put("totalItems", brandPage.getTotalElements());
        response.put("totalPages", brandPage.getTotalPages());
        response.put("pageSize", brandPage.getSize());
        response.put("isFirst", brandPage.isFirst());
        response.put("isLast", brandPage.isLast());

        return new ApiResponse<>(HttpStatus.OK.value(), "Product name fetched successfully", response);
    }

    @GetMapping("/products/filter/price/{price}")
    public ApiResponse<List<ProductResponse>> filterByPrice(@PathVariable String price) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Product filtered successfully", productUserService.filterByPrice(price));
    }

    @GetMapping("/products/filter/brand/{brandName}")
    public ApiResponse<List<ProductResponse>> filterByBrandName(@PathVariable String brandName) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Product filtered Successfully", productUserService.filterByBrand(brandName));
    }

    @GetMapping("/products/{id}")
    public ApiResponse<ProductResponse> getProductById(@PathVariable Long id) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Product fetched successfully", productUserService.getProductById(id));
    }
}