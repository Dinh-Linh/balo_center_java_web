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

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
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
    public DashboardSummaryDTO getDashboardSummary(String filter) {
        long totalProducts;
        long totalUsers;
        long totalOrders;
        Double totalRevenue;

        Timestamp startDate = null;
        Timestamp endDate = null;

        if ("today".equals(filter)) {
            LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
            LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
            startDate = Timestamp.valueOf(start);
            endDate = Timestamp.valueOf(end);
        } else if ("month".equals(filter)) {
            LocalDateTime start = LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()),
                    LocalTime.MIN);
            LocalDateTime end = LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()),
                    LocalTime.MAX);
            startDate = Timestamp.valueOf(start);
            endDate = Timestamp.valueOf(end);
        } else if ("year".equals(filter)) {
            LocalDateTime start = LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()),
                    LocalTime.MIN);
            LocalDateTime end = LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.lastDayOfYear()),
                    LocalTime.MAX);
            startDate = Timestamp.valueOf(start);
            endDate = Timestamp.valueOf(end);
        }

        if (startDate != null && endDate != null) {
            totalUsers = userRepo.countByCreatedDateBetween(startDate, endDate);
            totalOrders = orderRepo.countByDateBetween(startDate, endDate);
            totalRevenue = orderRepo.sumTotalPriceByDateBetween(startDate, endDate);
        } else {
            // No filter or invalid filter, get overall summary
            totalUsers = userRepo.count();
            totalOrders = orderRepo.count();
            totalRevenue = orderRepo.sumTotalPrice();
        }

        // Always get overall total products, regardless of date filter
        totalProducts = productRepo.count();

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

    @Override
    public List<com.example.balo_center.domain.dto.dashboard.OrderRevenueDTO> getTotalRevenueByStatus() {
        return orderRepo.findTotalRevenueByStatus();
    }
}