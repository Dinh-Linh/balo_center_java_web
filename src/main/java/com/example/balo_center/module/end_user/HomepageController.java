package com.example.balo_center.module.end_user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homepage")
public class HomepageController {
    @GetMapping
    public String vewHomePage() {
        return "end_user/eshopper-1.0.0/index";
    }
}
