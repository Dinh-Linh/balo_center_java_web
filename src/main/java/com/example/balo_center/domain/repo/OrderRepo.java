package com.example.balo_center.domain.repo;

import com.example.balo_center.domain.entity.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, String>, JpaSpecificationExecutor<Order> {
        @EntityGraph(attributePaths = { "orderDetails", "orderDetails.product", "user" })
        Optional<Order> findById(String id);

        @Query("SELECT SUM(o.totalPrice) FROM Order o WHERE o.status = 'DELIVERED'")
        Double sumTotalPrice();
}
