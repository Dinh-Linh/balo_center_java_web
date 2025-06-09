package com.example.balo_center.module.service.admin.impl;

import com.example.balo_center.domain.dto.dashboard.DashboardSummaryDTO;
import com.example.balo_center.domain.dto.dashboard.TopSellingProductDTO;
import com.example.balo_center.domain.repo.OrderDetailRepo;
import com.example.balo_center.domain.repo.OrderRepo;
import com.example.balo_center.domain.repo.ProductRepo;
import com.example.balo_center.domain.repo.UserRepo;
import com.example.balo_center.module.service.admin.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Override
    public DashboardSummaryDTO getDashboardSummary() {
        long totalProducts = productRepo.count();
        long totalUsers = userRepo.count();
        long totalOrders = orderRepo.count();
        Double totalRevenue = orderRepo.sumTotalPrice();

        return new DashboardSummaryDTO(
                totalProducts,
                totalUsers,
                totalOrders,
                totalRevenue != null ? totalRevenue : 0.0);
    }

    @Override
    public List<TopSellingProductDTO> getTopSellingProducts(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return orderDetailRepo.findTopSellingProducts(pageable);
    }
}