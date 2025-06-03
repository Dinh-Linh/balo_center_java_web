package com.example.balo_center.domain.mapper;

import com.example.balo_center.domain.dto.request.ProductRequest;
import com.example.balo_center.domain.dto.response.ProductResponse;
import com.example.balo_center.domain.entity.ProductData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductData toProduct(ProductRequest productRequest);

    ProductResponse toProductResponse(ProductData productData);

    List<ProductResponse> toListProductResponse(List<ProductData> productDataList);
}
