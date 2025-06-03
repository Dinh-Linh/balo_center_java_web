package com.example.balo_center.domain.dto.request;

import lombok.Builder;

@Builder
public record ProductRequest(
        String brandName,
        String name,
        String price,
        String imageLink,
        String detailLink,
        String description
) {
}
