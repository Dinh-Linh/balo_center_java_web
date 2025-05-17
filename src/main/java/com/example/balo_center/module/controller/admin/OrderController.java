package com.example.balo_center.module.controller.admin;

import com.example.balo_center.domain.entity.Order;
import com.example.balo_center.module.service.admin.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Xem danh sách đơn hàng (List view: /WEB-INF/view/admin/order.jsp)
     */
    @GetMapping
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

    /**
     * Xem chi tiết đơn hàng (Detail view:
     * /WEB-INF/view/admin/crud_order/detail.jsp)
     */
    @GetMapping("/{id}")
    public String orderDetail(@PathVariable String id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "admin/crud_order/detail";
    }

    /**
     * Cập nhật trạng thái đơn hàng, sau đó redirect về trang chi tiết với thông báo
     * thành công
     */
    @PostMapping("/{id}/status")
    public String updateStatus(
            @PathVariable String id,
            @RequestParam String status) {
        orderService.updateOrderStatus(id, status);
        return "redirect:/view/admin/order/" + id + "?success=true";
    }
}
