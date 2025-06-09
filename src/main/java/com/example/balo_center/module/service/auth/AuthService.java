package com.example.balo_center.module.service.auth;

import com.example.balo_center.domain.dto.LoginRequest;
import com.example.balo_center.domain.dto.RegisterRequest;
import com.example.balo_center.domain.entity.User;

public interface AuthService {
    public User register(RegisterRequest registerRequest);
    public User login(LoginRequest loginRequest);

    public boolean existsByEmail(String email);
}
