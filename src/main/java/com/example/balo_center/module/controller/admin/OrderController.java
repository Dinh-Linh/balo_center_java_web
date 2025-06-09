package com.example.balo_center.module.controller.admin;

import com.example.balo_center.domain.entity.Order;
import com.example.balo_center.module.service.admin.OrderService;
// import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/order")
// @RequiredArgsConstructor
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * Cập nhật trạng thái đơn hàng, sau đó redirect về trang chi tiết với thông báo
     * thành công
     */
    @PostMapping("/update-status")
    public String updateStatus(
            @RequestParam("orderId") String orderId,
            @RequestParam("status") String status,
            RedirectAttributes redirectAttributes) {
        try {
            orderService.updateOrderStatus(orderId, status);
            redirectAttributes.addFlashAttribute("successMessage", "Cập nhật trạng thái đơn hàng thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Cập nhật trạng thái đơn hàng thất bại");
        }
        return "redirect:/view/admin/order";
    }

    /**
     * Export orders to CSV file
     */
    @GetMapping("/export/csv")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=danh_sach_don_hang.csv");

        orderService.exportToCSV(response.getWriter());
    }
}
