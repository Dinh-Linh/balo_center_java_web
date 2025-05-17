package com.example.balo_center.domain.dto.response;


import java.sql.Timestamp;

public record UserDTO (
        String id,
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
