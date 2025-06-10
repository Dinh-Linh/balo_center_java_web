package com.example.balo_center.controller.user;

import com.example.balo_center.domain.dto.request.ChangePasswordRequest;
import com.example.balo_center.domain.dto.request.UpdateProfileRequest;
import com.example.balo_center.domain.dto.response.UserProfileResponse;
import com.example.balo_center.domain.entity.User;
import com.example.balo_center.repository.UserRepository;
import com.example.balo_center.service.user.impl.UserDetailsImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponse> getUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userRepository.findById(userDetails.getId())
                .orElseThrow();
        List<String> roles = Arrays.asList(user.getRole().split(","));
        UserProfileResponse profile = new UserProfileResponse(
                user.getId(), user.getEmail(), user.getFullName(), roles);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateUserProfile(@Valid @RequestBody UpdateProfileRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).orElseThrow();
        if (!user.getEmail().equals(request.email()) && userRepository.existsByEmail(request.email())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }
        user.setFullName(request.name());
        user.setEmail(request.email());
        userRepository.save(user);
        return ResponseEntity.ok("Profile updated successfully");
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        User user = userRepository.findById(userDetails.getId()).orElseThrow();
        if (!encoder.matches(request.oldPassword(), user.getPassword())) {
            return ResponseEntity.badRequest().body("Error: Old password is incorrect!");
        }
        if (!request.newPassword().equals(request.confirmPassword())) {
            return ResponseEntity.badRequest().body("Error: New password and confirm password do not match!");
        }
        user.setPassword(encoder.encode(request.newPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("Password changed successfully");
    }
}
