package com.example.balo_center.controller.user;

import com.example.balo_center.domain.dto.request.LoginRequest;
import com.example.balo_center.domain.dto.request.RegistrationRequest;
import com.example.balo_center.domain.dto.response.ApiResponse;
import com.example.balo_center.service.user.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class ApiAuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public ApiResponse<?> registerUser(@Valid @RequestBody RegistrationRequest registrationRequest) {
        return authService.register(registrationRequest);
    }

    @PostMapping("/logout")
    public ApiResponse<?> logoutUser(HttpServletRequest request, HttpServletResponse response) {
        return authService.logout(request, response);
    }
}