package com.example.balo_center.controller.user;

public record PagingAndSortingParams(
        int page,
        int size,
        String sortBy,
        String sortDir
) {
}
