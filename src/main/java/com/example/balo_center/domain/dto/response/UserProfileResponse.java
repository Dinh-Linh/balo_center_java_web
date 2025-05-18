package com.example.balo_center.domain.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record UserProfileResponse(
        Long id,
        String email,
        String name,
        List<String> roles
) {
}
