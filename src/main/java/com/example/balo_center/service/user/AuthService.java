package com.example.balo_center.service.user;

import com.example.balo_center.domain.dto.request.LoginRequest;
import com.example.balo_center.domain.dto.request.RegistrationRequest;
import com.example.balo_center.domain.dto.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    ApiResponse<?> login(LoginRequest loginRequest);
    ApiResponse<?> register(RegistrationRequest registrationRequest);
    ApiResponse<?> logout(HttpServletRequest request, HttpServletResponse response);
}