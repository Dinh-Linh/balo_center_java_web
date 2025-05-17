package com.example.balo_center.module.service.auth.impl;

import com.example.balo_center.domain.dto.LoginRequest;
import com.example.balo_center.domain.dto.RegisterRequest;
import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.repo.UserRepo;
import com.example.balo_center.module.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User register(RegisterRequest request) {
        if (userRepo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email đã tồn tại");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFullname(request.getFullName());
        user.setRole("ROLE_USER"); // mặc định đăng ký là USER
        return userRepo.save(user);
    }

    @Override
    public User login(LoginRequest loginRequest) {
        User user = userRepo.findUsersByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("Tài khoản không tồn tại"));
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("Sai mật khẩu");
        }
        return user;
    }
}
