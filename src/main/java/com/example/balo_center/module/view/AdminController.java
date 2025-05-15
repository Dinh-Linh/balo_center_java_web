package com.example.balo_center.module.view;

import com.example.balo_center.domain.entity.User;
import com.example.balo_center.share.UserDataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public String user(Model model){
        List<User> users = UserDataGenerator.generateMockUsers();

        model.addAttribute("users", users);
        return "admin/user";}




    //View product
    @GetMapping(value = "admin/product")
    public String product(){return "admin/product";}

    //View order
    @GetMapping(value = "admin/order")
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
