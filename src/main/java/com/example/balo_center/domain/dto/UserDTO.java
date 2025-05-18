package com.example.balo_center.domain.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserDTO {
    private String id;
    private String email;
    private String fullname;
    private String password;
    private String userPhone;
    private String role;
    private String status;
    private String avatar;
    private Timestamp createdDate;
}
