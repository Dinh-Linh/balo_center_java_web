package com.example.balo_center.module.view;

import com.example.balo_center.domain.dto.RegisterRequest;
import com.example.balo_center.domain.entity.User;
import com.example.balo_center.module.service.auth.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping(value = "/register")
    public String register(RegisterRequest request, String confirmPassword, RedirectAttributes redirectAttributes){
        if(!request.getPassword().equals(confirmPassword)){
            redirectAttributes.addFlashAttribute("error", "Mật khẩu không khớp");
            return "redirect:/view/auth/register";
        }

        try{
            authService.register(request);
            redirectAttributes.addFlashAttribute("success", "Đăng ký thành công");
            return "redirect:/view/auth/login";
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("error", e);
            return "redirect:/view/auth/register";
        }
    }
}
