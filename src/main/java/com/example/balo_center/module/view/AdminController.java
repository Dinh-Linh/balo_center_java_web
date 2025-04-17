package com.example.balo_center.module.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Simple Datatable
@Controller
@RequestMapping(value = "view/")
public class AdminController {
    //View user
    @GetMapping(value = "admin/dashboard")
    public String dashboard(){
        return "admin/index";
    }

    @GetMapping(value = "admin/user")
    public String user(){return "admin/list_user";}

    //View product
    @GetMapping(value = "admin/product/list")
    public String product(){return "admin/product";}

    //View order
    @GetMapping(value = "admin/order/list")
    public String order(){return "admin/order";}

    //View sidebar
    @GetMapping(value = "admin/sidebar")
    public String sidebar(){return "admin/sidebar";}

    //View header
    @GetMapping(value = "admin/header")
    public String header(){return "admin/header";}

    //View footer
    @GetMapping(value = "admin/footer")
    public String footer(){return "admin/footer";}
}
