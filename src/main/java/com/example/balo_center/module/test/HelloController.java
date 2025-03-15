package com.example.balo_center.module.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping(value = "/hello")
    public String getHello(){
        return "hello";
    }
}
