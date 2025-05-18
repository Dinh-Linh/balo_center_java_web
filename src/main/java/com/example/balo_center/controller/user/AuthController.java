package com.example.balo_center.controller.user;

import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.dto.request.LoginRequest;
import com.example.balo_center.domain.dto.request.RegistrationRequest;
import com.example.balo_center.repository.UserRepository;
import com.example.balo_center.service.user.impl.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public AuthController(AuthenticationManager authenticationManager,
                          UserRepository userRepository,
                          PasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    // View endpoints
    @GetMapping("/view/auth/login")
    public String viewLogin(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid email or password");
        }
        return "auth/login";
    }

    @GetMapping("/view/auth/register")
    public String viewRegister() {
        return "auth/register";
    }

    // REST API endpoints
    @PostMapping("/api/auth/login")
    @ResponseBody
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(Map.of(
                "message", "Login successful",
                "username", userDetails.getUsername(),
                "email", userDetails.getEmail(),
                "roles", userDetails.getAuthorities()
        ));
    }

    @PostMapping("/api/auth/register")
    @ResponseBody
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.email())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }
        if (!signUpRequest.password().equals(signUpRequest.confirmPassword())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Password and confirm password do not match!");
        }

        User user = new User();
        user.setEmail(signUpRequest.email());
        user.setFullName(signUpRequest.name());
        user.setPassword(encoder.encode(signUpRequest.password()));
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/api/auth/logout")
    @ResponseBody
    public ResponseEntity<?> logoutUser(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return ResponseEntity.ok("Logged out successfully");
    }
}