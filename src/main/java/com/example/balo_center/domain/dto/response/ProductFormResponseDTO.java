package com.example.balo_center.domain.dto.response;

import lombok.Builder;

@Builder
public record ProductFormResponseDTO (
        String id,
        String productName,
        String categoryName,
        String branchName,
        Integer quantity,
        Integer sold,
        Double price,
        String shortDesc,
        String detailsDesc
) {


}
