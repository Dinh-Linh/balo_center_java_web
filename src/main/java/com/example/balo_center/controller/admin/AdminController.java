package com.example.balo_center.controller.admin;

import com.example.balo_center.domain.dto.response.ProductFormResponseDTO;
import com.example.balo_center.domain.dto.response.UserDTO;
import com.example.balo_center.service.admin.ProductService;
import com.example.balo_center.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//Simple Datatable
@Controller
@RequestMapping(value = "view/")
@RequiredArgsConstructor
public class AdminController {
    private final ProductService productService;
    private final UserService userService;

    //View user
    @GetMapping(value = "admin/dashboard")
    public String dashboard() {
        return "admin/index";
    }

    @GetMapping(value = "admin/user")
    public String user(Model model){
        //List<User> users = UserDataGenerator.generateMockUsers();
        List<UserDTO> users = userService.getAllUser();

        model.addAttribute("users", users);
        return "admin/user";
    }

    //View product
    @GetMapping(value = "admin/product")
    public String product(Model model) {
        List<ProductFormResponseDTO> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "admin/product";
    }

    //View order
    @GetMapping(value = "admin/order")
    public String order() {
        return "admin/order";
    }

    //View sidebar
    @GetMapping(value = "admin/sidebar")
    public String sidebar() {
        return "admin/sidebar";
    }

    //View header
    @GetMapping(value = "admin/header")
    public String header(){return "admin/header";}

    //View footer
    @GetMapping(value = "admin/footer")
    public String footer() {
        return "admin/footer";
    }


}
