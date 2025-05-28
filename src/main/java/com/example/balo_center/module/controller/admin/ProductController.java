package com.example.balo_center.module.controller.admin;

import com.example.balo_center.domain.dto.ProductFormDTO;
import com.example.balo_center.module.service.admin.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String addProduct(@ModelAttribute ProductFormDTO form, RedirectAttributes redirectAttributes) {
        try {
            productService.saveProduct(form);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm sản phẩm thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Lỗi khi thêm mới sản phẩm");
        }
        return "redirect:/view/admin/product";
    }

    @PostMapping("/update")
    public String editProduct(@ModelAttribute ProductFormDTO form, RedirectAttributes redirectAttributes) {
        try {
            productService.updateProduct(form.getId(), form);
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
