package com.example.balo_center.module.service.admin;

import com.example.balo_center.domain.dto.dashboard.DashboardSummaryDTO;
import com.example.balo_center.domain.dto.dashboard.TopSellingProductDTO;

import java.util.List;

public interface DashboardService {
    DashboardSummaryDTO getDashboardSummary();

    List<TopSellingProductDTO> getTopSellingProducts(int limit);
}