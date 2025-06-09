package com.example.balo_center.module.controller.admin;

import com.example.balo_center.domain.dto.UserDTO;
import com.example.balo_center.domain.dto.UserFormDTO;
import com.example.balo_center.domain.request.SearchRequest;
import com.example.balo_center.module.service.admin.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "view/")
public class UserController {

    @Autowired
    private UserService userService;
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

}
