package com.example.balo_center.module.view;

import com.example.balo_center.domain.dto.UserDTO;
import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.request.SearchRequest;
import com.example.balo_center.module.service.auth.UserService;
import com.example.balo_center.share.UserDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//Simple Datatable
@Controller
@RequestMapping(value = "view/")
public class AdminController {
    @Autowired
    private UserService userService;

    //View user
    @GetMapping(value = "admin/dashboard")
    public String dashboard(){
        return "admin/index";
    }



//    @GetMapping(value = "admin/user")
//    public String user(Model model){
//        List<UserDTO> users = userService.getAllUser();
//        model.addAttribute("users", users);
//        return "admin/user";}

    @GetMapping(value = "admin/user")
    public ModelAndView user(@ModelAttribute SearchRequest searchRequest){
        ModelAndView modelAndView = new ModelAndView("admin/user");
        List<UserDTO> users = userService.findUser(searchRequest);
        long totalUsers = userService.countTotalUsers(searchRequest);
        int totalPages = (int) Math.ceil((double) totalUsers / searchRequest.getSize());
        
        modelAndView.addObject("searchRequest", searchRequest);
        modelAndView.addObject("users", users);
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("currentPage", searchRequest.getPage());
        return modelAndView;
    }



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
