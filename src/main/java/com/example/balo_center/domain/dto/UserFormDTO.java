package com.example.balo_center.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserFormDTO {
    private String id;
    private String email;
    private String fullname;
    private String password;
    private String userPhone;
    private String role;
    private String status;
    private String avatar;
    private Timestamp createdDate;

    public UserFormDTO(String id, String email, String fullname, String password, String userPhone, String role,
            String status, String avatar, Timestamp createdDate) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.userPhone = userPhone;
        this.role = role;
        this.status = status;
        this.avatar = avatar;
        this.createdDate = createdDate;
    }
}