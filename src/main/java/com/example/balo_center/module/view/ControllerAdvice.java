package com.example.balo_center.module.view;

import com.example.balo_center.domain.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    private UserRepo userRepo;

    public ControllerAdvice(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @ModelAttribute("username")
    public String username() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getName())) {
            System.out.println("No authenticated user found");
            return "Người dùng";
        }
        String email = authentication.getName();
        System.out.println("Authenticated email: " + email);
        return userRepo.findUsersByEmail(email)
                .map(User::getFullname)
                .orElse("Người dùng");
    }
}
