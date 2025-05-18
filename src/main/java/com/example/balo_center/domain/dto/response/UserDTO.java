package com.example.balo_center.domain.dto.response;


import lombok.Builder;

import java.sql.Timestamp;

@Builder
public record UserDTO (
        String email,
        String fullName,
        String password,
        String userPhone,
        String role,
        String status,
        String avatar,
        Timestamp createdDate
) {

}
