package com.example.balo_center.module.view;

import com.example.balo_center.share.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewEndUserController extends BaseController {
    @GetMapping("/homepage")
    public String vewHomePage() {
        return "end_user/index";
    }

    @GetMapping("/cart")
    public String viewCart(){
        return "end_user/cart";
    }
    @GetMapping("/detail")
    public String viewDetail(){
        return "end_user/detail";
    }

    @GetMapping("/shop")
    public String viewShop(){
        return "end_user/shop";
    }

    @GetMapping("/contact")
    public String viewContact(){
        return "end_user/contact";
    }
    @GetMapping("/checkout")
    public String viewCheckout(){
        return "end_user/checkout";
    }
}
