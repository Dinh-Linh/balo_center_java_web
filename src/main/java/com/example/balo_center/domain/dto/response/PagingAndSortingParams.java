package com.example.balo_center.domain.dto.response;

import lombok.Builder;

@Builder
public record PagingAndSortingParams(
        int page,
        int size,
        String sortBy,
        String sortDir
) {
}
