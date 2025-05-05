package com.example.balo_center.module.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "view/")
public class AuthController {
    @GetMapping(value = "auth/login")
    public String viewLogin(@RequestParam(value = "error", required = false) String error, Model model){
        if(error != null){
            model.addAttribute("error", "Email hoặc mật khẩu không đúng");
        }
        return "auth/login";
    }

    @GetMapping(value = "auth/register")
    public String viewRegister(){
        return "auth/register";
    }
}
