package com.example.balo_center.service.user.impl;

import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.dto.request.LoginRequest;
import com.example.balo_center.domain.dto.request.RegistrationRequest;
import com.example.balo_center.domain.dto.response.ApiResponse;
import com.example.balo_center.repository.UserRepository;
import com.example.balo_center.security.JwtUtil;
import com.example.balo_center.service.user.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    @Override
    public ApiResponse<?> login(LoginRequest loginRequest) {
        // Check if user exists
        User user = userRepository.findUsersByEmail(loginRequest.email())
                .orElse(null);

        if (user == null) {
            return new ApiResponse<>(
                    HttpStatus.UNAUTHORIZED.value(),
                    "Invalid email or password",
                    null
            );
        }

        // Verify password with encoder
        if (!encoder.matches(loginRequest.password(), user.getPassword())) {
            return new ApiResponse<>(
                    HttpStatus.UNAUTHORIZED.value(),
                    "Invalid email or password",
                    null
            );
        }

        // Proceed with authentication
        return getApiResponse(loginRequest, authenticationManager, jwtUtil);
    }

    public static ApiResponse<?> getApiResponse(LoginRequest loginRequest, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtil.generateJwtToken(userDetails);

        Map<String, Object> loginData = Map.of(
                "token", jwt,
                "username", userDetails.getUsername(),
                "email", userDetails.getEmail(),
                "roles", userDetails.getAuthorities()
        );

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Login successful",
                loginData
        );
    }

    @Override
    public ApiResponse<?> register(RegistrationRequest registrationRequest) {
        if (userRepository.existsByEmail(registrationRequest.email())) {
            return new ApiResponse<>(
                    HttpStatus.BAD_REQUEST.value(),
                    "Error: Email is already in use!",
                    null
            );
        }

        // Create new user's account
        User user = new User();
        user.setEmail(registrationRequest.email());
        user.setPassword(encoder.encode(registrationRequest.password()));
        user.setRole("USER");

        userRepository.save(user);

        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "User registered successfully!",
                null
        );
    }

    @Override
    public ApiResponse<?> logout(HttpServletRequest request, HttpServletResponse response) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Logged out successfully",
                null
        );
    }
}