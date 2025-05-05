package com.example.balo_center.module.view;

import com.example.balo_center.domain.dto.LoginRequest;
import com.example.balo_center.domain.entity.User;
import com.example.balo_center.module.service.auth.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "view/")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping(value = "auth/login")
    public String viewLogin(@RequestParam(value = "error", required = false) String error, Model model){
        if(error != null){
            model.addAttribute("error", "Email hoặc mật khẩu không đúng");
        }
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, HttpSession session, RedirectAttributes redirectAttributes){
        try {
            User user = authService.login(loginRequest);
            session.setAttribute("user", user);
            if ("ROLE_ADMIN".equals(user.getRole())) {
                return "redirect:/view/admin/dashboard";
            } else {
                return "redirect:/view/user/home";
            }
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/view/auth/login?error=true";
        }
    }

    @GetMapping(value = "auth/register")
    public String viewRegister(){
        return "auth/register";
    }
}
