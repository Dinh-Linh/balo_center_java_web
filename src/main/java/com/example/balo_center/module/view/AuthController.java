package com.example.balo_center.module.view;

import com.example.balo_center.module.service.auth.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "view/")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping(value = "auth/login")
    public String viewLogin(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid email or password");
        }
        return "auth/login";
    }

    @GetMapping(value = "auth/register")
    public String viewRegister() {
        return "auth/register";
    }
}
