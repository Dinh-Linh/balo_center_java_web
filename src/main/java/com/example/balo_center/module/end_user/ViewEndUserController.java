package com.example.balo_center.module.end_user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
// @RequestMapping("/homepage")
public class ViewEndUserController {
    @GetMapping({ "/", "/homepage" })
    public RedirectView viewHomePage() {
        return new RedirectView("/resources/template/eshopper/index.jsp");
    }

    @GetMapping("/cart")
    public RedirectView viewCart() {
        return new RedirectView("/resources/template/eshopper/cart.jsp");
    }

    @GetMapping("/detail")
    public RedirectView viewDetail() {
        return new RedirectView("/resources/template/eshopper/detail.jsp");
    }
}
