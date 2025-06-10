package com.example.balo_center.domain.repo;

import com.example.balo_center.domain.entity.OrderDetail;
import com.example.balo_center.domain.dto.dashboard.TopSellingProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {

    @Query("SELECT new com.example.balo_center.domain.dto.dashboard.TopSellingProductDTO(od.product.productName, SUM(od.quantity), od.product.price) "
            +
            "FROM OrderDetail od GROUP BY od.product.productName, od.product.price ORDER BY SUM(od.quantity) DESC")
    List<TopSellingProductDTO> findTopSellingProducts(org.springframework.data.domain.Pageable pageable);
}