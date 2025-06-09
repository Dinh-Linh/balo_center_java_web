package com.example.balo_center.module.view;

//import com.example.balo_center.domain.dto.ProductDTO;

import com.example.balo_center.domain.dto.ProductFormDTO;
import com.example.balo_center.domain.dto.UserFormDTO;
import com.example.balo_center.domain.dto.dashboard.DashboardSummaryDTO;
import com.example.balo_center.domain.dto.dashboard.TopSellingProductDTO;
import com.example.balo_center.domain.entity.Order;
import com.example.balo_center.domain.repo.BranchRepo;
import com.example.balo_center.domain.repo.CategoryRepo;
import com.example.balo_center.module.service.admin.DashboardService;
import com.example.balo_center.module.service.admin.OrderService;
import com.example.balo_center.module.service.admin.ProductService;
import com.example.balo_center.module.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    @Autowired
    private DashboardService dashboardService;
    // public AdminController(ProductService productService, OrderService
    // orderService , UserService userService) {
    // this.productService = productService;
    // this.orderService = orderService;
    // this.userService = userService;
    // }

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private BranchRepo branchRepo;

    // View user
    @GetMapping(value = "admin/dashboard")
    public String dashboard(Model model) {
        DashboardSummaryDTO summary = dashboardService.getDashboardSummary();
        List<TopSellingProductDTO> topSellingProducts = dashboardService.getTopSellingProducts(5); // Get top 5

        model.addAttribute("summary", summary);
        model.addAttribute("topSellingProducts", topSellingProducts);

        return "admin/index";
    }



    @GetMapping(value = "admin/user")
    public String user(Model model,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "10") int size,
                       @RequestParam(required = false) String searchName,
                       @RequestParam(required = false) String role,
                       @RequestParam(required = false) String sortBy) {
        Page<UserFormDTO> usersPage = userService.getAllUsers(page, size, searchName, role, sortBy);

        model.addAttribute("users", usersPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", usersPage.getTotalPages());
        model.addAttribute("totalItems", usersPage.getTotalElements());
        model.addAttribute("searchName", searchName);
        model.addAttribute("role", role);
        model.addAttribute("sortBy", sortBy);
        return "admin/user";
    }



    // View product
    @GetMapping(value = "admin/product")
    public String product(Model model,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String searchName,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String sortBy) {
        Page<ProductFormDTO> products = productService.getAllProduct(page - 1, size, searchName, brand, category,
                sortBy);
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
    public String manageOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String searchId,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String sortBy,
            Model model) {
        Page<Order> ordersPage = orderService.getAllOrders(page, size, searchId, status, sortBy);

        model.addAttribute("orders", ordersPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", ordersPage.getTotalPages());
        model.addAttribute("totalItems", ordersPage.getTotalElements());
        model.addAttribute("searchId", searchId);
        model.addAttribute("status", status);
        model.addAttribute("sortBy", sortBy);

        return "admin/order";
    }

    // View sidebar
    @GetMapping(value = "admin/sidebar")
    public String sidebar() {
        return "admin/sidebar";
    }

    // View header
    @GetMapping(value = "admin/header")
    public String header() {
        return "admin/header";
    }

    // View footer
    @GetMapping(value = "admin/footer")
    public String footer() {
        return "admin/footer";
    }

}
