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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/import")
    public String importProducts(@RequestParam("file") MultipartFile file,
                                 RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Vui lòng chọn file Excel");
            return "redirect:/admin/products/import";
        }

        if (!file.getOriginalFilename().endsWith(".xlsx")) {
            redirectAttributes.addFlashAttribute("error", "File phải có định dạng .xlsx");
            return "redirect:/admin/products/import";
        }

        try {
            List<Map<String, String>> results = productService.importProductsFromExcel(file);

            // Phân loại kết quả
            List<Map<String, String>> successResults = results.stream()
                    .filter(r -> "success".equals(r.get("status")))
                    .toList();
            List<Map<String, String>> errorResults = results.stream()
                    .filter(r -> "error".equals(r.get("status")))
                    .toList();

            // Thêm thông báo kết quả
            if (!successResults.isEmpty()) {
                redirectAttributes.addFlashAttribute("success",
                        "Đã import thành công " + successResults.size() + " sản phẩm");
            }
            if (!errorResults.isEmpty()) {
                redirectAttributes.addFlashAttribute("errors", errorResults);
            }

            return "redirect:view/admin/product";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Lỗi khi import: " + e.getMessage());
            return "redirect:view/admin/product";
        }
    }

}
