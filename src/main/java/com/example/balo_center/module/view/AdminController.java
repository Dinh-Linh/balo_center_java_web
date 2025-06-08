package com.example.balo_center.module.view;

//import com.example.balo_center.domain.dto.ProductDTO;
import com.example.balo_center.domain.entity.Order;
import com.example.balo_center.domain.dto.ProductFormDTO;
import com.example.balo_center.domain.dto.UserDTO;
import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.repo.BranchRepo;
import com.example.balo_center.domain.repo.CategoryRepo;
import com.example.balo_center.module.service.admin.OrderService;
import com.example.balo_center.module.service.admin.OrderService;
import com.example.balo_center.module.service.admin.ProductService;
import com.example.balo_center.module.service.auth.UserService;
import com.example.balo_center.share.UserDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//Simple Datatable
@Controller
@RequestMapping(value = "view/")
public class AdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
//    public AdminController(ProductService productService, OrderService orderService , UserService userService) {
//        this.productService = productService;
//        this.orderService = orderService;
//        this.userService = userService;
//    }



    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private BranchRepo branchRepo;

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
    public String product(Model model, 
                         @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "10") int size,
                         @RequestParam(required = false) String searchName,
                         @RequestParam(required = false) String brand,
                         @RequestParam(required = false) String category,
                         @RequestParam(required = false) String sortBy) {
        Page<ProductFormDTO> products = productService.getAllProduct(page - 1, size, searchName, brand, category, sortBy);
        model.addAttribute("products", products.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", products.getTotalPages());
        model.addAttribute("totalItems", products.getTotalElements());
        model.addAttribute("searchName", searchName);
        model.addAttribute("brand", brand);
        model.addAttribute("category", category);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("brands", branchRepo.findAll());
        return "admin/product";
    }

    // View order
    @GetMapping("admin/order")
    public String listOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        List<Order> all = orderService.getAllOrders();
        int totalItems = all.size();
        int fromIndex = page * size;
        int toIndex = Math.min(fromIndex + size, totalItems);
        List<Order> orders = all.subList(
                Math.min(fromIndex, totalItems),
                Math.min(toIndex, totalItems));
        int totalPages = (int) Math.ceil((double) totalItems / size);

        model.addAttribute("orders", orders);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("size", size);
        return "admin/order"; // maps to /WEB-INF/view/admin/order.jsp
    }

    // View order detail
    @GetMapping("admin/order/{id}")
    public String viewOrderDetail(@PathVariable String id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "admin/crud_order/detail";
    }

    //View sidebar
    @GetMapping(value = "admin/sidebar")
    public String sidebar() {
        return "admin/sidebar";
    }

    //View header
    @GetMapping(value = "admin/header")
    public String header() {
        return "admin/header";
    }

    //View footer
    @GetMapping(value = "admin/footer")
    public String footer() {
        return "admin/footer";
    }


}
