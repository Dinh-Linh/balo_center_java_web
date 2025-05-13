package com.example.balo_center.module.controller.admin;

import com.example.balo_center.domain.dto.ProductDTO;
import com.example.balo_center.domain.dto.ProductFormDTO;
import com.example.balo_center.module.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductFormDTO form){
        productService.saveProduct(form);
        return "redirect:/view/admin/product";
    }

    @GetMapping("/admin/product/view/{id}")
    public String viewProduct(@PathVariable String id, Model model) {
        ProductFormDTO product = productService.getProductById(id); // hoặc mapper từ Entity -> DTO
        model.addAttribute("product", product);
        return "view_product"; // sẽ render ra view_product.jsp
    }

}
