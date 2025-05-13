package com.example.balo_center.module.view;

import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.entity.repo.UserRepo;
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
    public String usernmae() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepo.findUsersByEmail(email)
                .map(User::getFullname)
                .orElse("Người dùng");

    }
}
