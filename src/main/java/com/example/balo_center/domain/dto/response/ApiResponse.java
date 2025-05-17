package com.example.balo_center.domain.dto.response;

public record ApiResponse<T>(
        int code,
        String message,
        T data
) {
}
