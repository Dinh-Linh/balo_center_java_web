package com.example.balo_center.domain.repo;

import com.example.balo_center.domain.entity.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, String>, JpaSpecificationExecutor<Order> {
        @EntityGraph(attributePaths = { "orderDetails", "orderDetails.product", "user" })
        Optional<Order> findById(String id);

        @Query("SELECT SUM(o.totalPrice) FROM Order o WHERE o.status = 'COMPLETED'")
        Double sumTotalPrice();

        long countByDateBetween(java.sql.Timestamp startDate, java.sql.Timestamp endDate);

        @Query("SELECT SUM(o.totalPrice) FROM Order o WHERE o.status = 'COMPLETED' AND o.date BETWEEN :startDate AND :endDate")
        Double sumTotalPriceByDateBetween(java.sql.Timestamp startDate, java.sql.Timestamp endDate);

        @Query("SELECT new com.example.balo_center.domain.dto.dashboard.OrderRevenueDTO(o.status, SUM(o.totalPrice)) " +
                        "FROM Order o GROUP BY o.status")
        List<com.example.balo_center.domain.dto.dashboard.OrderRevenueDTO> findTotalRevenueByStatus();
}
