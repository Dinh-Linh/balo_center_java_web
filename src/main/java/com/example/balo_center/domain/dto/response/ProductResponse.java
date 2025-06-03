package com.example.balo_center.domain.dto.response;

import lombok.Builder;

@Builder
public record ProductResponse(
        String brandName,
        String name,
        String price,
        String imageLink,
        String detailLink,
        String description
) {
}
