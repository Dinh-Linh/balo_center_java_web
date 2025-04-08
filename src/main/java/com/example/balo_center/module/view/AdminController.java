package com.example.balo_center.module.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "view/")
public class AdminController {
    @GetMapping(value = "admin/dashboard")
    public String dashboard(){
        return "admin/index";
    }
}
