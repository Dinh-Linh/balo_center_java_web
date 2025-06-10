package com.example.balo_center.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
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
}