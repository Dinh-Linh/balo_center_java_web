package com.example.balo_center.module;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping(value = "login")
    public String viewLogin(){
        return "auth/login";
    }
}
