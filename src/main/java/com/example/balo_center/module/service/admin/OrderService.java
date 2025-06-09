package com.example.balo_center.module.service.admin;

import com.example.balo_center.domain.entity.Order;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public interface OrderService {
    /**
     * Lấy tất cả đơn hàng
     */
    Page<Order> getAllOrders(int page, int size, String searchId, String status, String sortBy);

    /**
     * Lấy chi tiết đơn hàng theo ID
     */
    Order getOrderById(String id);

    /**
     * Cập nhật trạng thái đơn hàng
     */
    Order updateOrderStatus(String id, String status);

    /**
     * Xuất danh sách đơn hàng ra file CSV
     */
    void exportToCSV(PrintWriter writer) throws IOException;
}
