package com.example.balo_center.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;
}
