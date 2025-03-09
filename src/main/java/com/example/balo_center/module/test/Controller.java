package com.example.balo_center.module.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping(value = "hello")
    public String getHello(){
        return "";
    }
}
