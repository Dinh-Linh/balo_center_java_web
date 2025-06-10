package com.example.balo_center.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    @GetMapping("/")
    public String adminDashboard() {
        // This will attempt to render a Thymeleaf template, e.g., templates/admin/dashboard.html
        // You'll need to create this file.
        return "admin/dashboard"; // Example, adjust to your actual admin dashboard template
    }

    // Add other admin-specific view mappings here
    // For example, if you had admin/products, admin/users, etc.
}
