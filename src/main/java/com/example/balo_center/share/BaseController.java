package com.example.balo_center.share;

import com.example.balo_center.authentication.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
public class BaseController {

    @ModelAttribute("currentUser")
    public CustomUserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            log.info("Principal type: {}", authentication.getPrincipal().getClass().getName());
            if (authentication.getPrincipal() instanceof CustomUserDetails) {
                CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
                log.info("User details: email={}, fullName={}", userDetails.getEmail(), userDetails.getFullName());
                return userDetails;
            }
        }
        return null;
    }
}