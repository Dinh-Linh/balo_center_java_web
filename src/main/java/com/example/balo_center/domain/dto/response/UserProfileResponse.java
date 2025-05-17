package com.example.balo_center.domain.dto.response;

import java.util.List;

public record UserProfileResponse(
        Long id,
        String username,
        String email,
        String name,
        List<String> roles
) {
}
