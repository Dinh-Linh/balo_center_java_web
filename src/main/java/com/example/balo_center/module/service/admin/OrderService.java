package com.example.balo_center.module.service.admin;

import com.example.balo_center.domain.entity.Order;

import java.util.List;

public interface OrderService {
    /**
     * Lấy tất cả đơn hàng
     */
    List<Order> getAllOrders();

    /**
     * Lấy chi tiết đơn hàng theo ID
     */
    Order getOrderById(String id);

    /**
     * Cập nhật trạng thái đơn hàng
     */
    Order updateOrderStatus(String id, String status);
}
