package com.example.balo_center.domain.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardSummaryDTO {
    private long totalProducts;
    private long totalUsers;
    private long totalOrders;
    private double totalRevenue;
}