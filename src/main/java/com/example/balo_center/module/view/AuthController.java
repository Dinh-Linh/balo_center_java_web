package com.example.balo_center.module.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "view/")
public class AuthController {
    @GetMapping(value = "auth/login")
    public String viewLogin(){
        return "auth/login";
    }

    @GetMapping
    public String viewRegister(){
        return "auth/register";
    }
}
