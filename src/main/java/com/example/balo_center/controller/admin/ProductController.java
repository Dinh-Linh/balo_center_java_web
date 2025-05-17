package com.example.balo_center.controller.admin;

import com.example.balo_center.domain.dto.response.ProductFormResponseDTO;
import com.example.balo_center.service.admin.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductFormResponseDTO form, RedirectAttributes redirectAttributes) {
        try {
            productService.saveProduct(form);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm sản phẩm thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Lỗi khi thêm mới sản phẩm");
        }
        return "redirect:/view/admin/product";
    }

    @GetMapping("/admin/product/view/{id}")
    public String viewProduct(@PathVariable String id, Model model) {
        ProductFormResponseDTO product = productService.getProductById(id); // hoặc mapper từ Entity -> DTO
        model.addAttribute("product", product);
        return "view_product"; // sẽ render ra view_product.jsp
    }

    @PostMapping("/update")
    public String editProduct(@ModelAttribute ProductFormResponseDTO form, RedirectAttributes redirectAttributes) {
        try {
            productService.updateProduct(form.id(), form);
            redirectAttributes.addFlashAttribute("successMessage", "Đã cập nhật sản phẩm");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Cập nhật thông tin sản phẩm thất bại");
        }
        return "redirect:/view/admin/product";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") String productId, RedirectAttributes redirectAttributes) {
        try {
            productService.deleteProduct(productId);
            redirectAttributes.addFlashAttribute("successMessage", "Đã xoá sản phẩm");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Xoá sản phẩm thất bại");
        }
        return "redirect:/view/admin/product";
    }

}
