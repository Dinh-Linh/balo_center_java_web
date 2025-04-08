package com.example.balo_center.module.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "admin/")
public class AdminController {
    @GetMapping(value = "/dashboard")
    public String dashboard(){
        return "admin/index";
    }
}
