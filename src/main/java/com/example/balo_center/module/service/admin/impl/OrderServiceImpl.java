package com.example.balo_center.module.service.admin.impl;

import com.example.balo_center.domain.entity.Order;
import com.example.balo_center.domain.entity.repo.OrderRepo;
import com.example.balo_center.module.service.admin.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo repo;

    @Override
    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    @Override
    public Order getOrderById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found: " + id));
    }

    @Override
    public Order updateOrderStatus(String id, String status) {
        Order order = getOrderById(id);
        order.setStatus(status);
        return repo.save(order);
    }
}
