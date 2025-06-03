package com.example.balo_center.repository;

import com.example.balo_center.domain.entity.ProductData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductUserRepository extends JpaRepository<ProductData, Long> {
    @Query(
            value = "SELECT DISTINCT p.brandName FROM ProductData p",
            // Dùng khi có truy vấn phức tạp như DISTINCT để đến số lượng bản ghi
            countQuery = "SELECT COUNT(DISTINCT p.brandName) FROM ProductData p"
    )
    Page<String> getAllBrandName(Pageable pageable);

    @Query(
            value = "SELECT p FROM ProductData p"
    )
    Page<ProductData> getAllProduct(Pageable pageable);

    @Query(
            value = "SELECT p FROM ProductData p WHERE p.price = :price"
    )
    Page<ProductData> getProductDataByPrice(String price, Pageable pageable);

    @Query(
            value = "SELECT p FROM ProductData p WHERE p.brandName = :brandName"
    )
    Page<ProductData> getProductDataByBrandName(String brandName, Pageable pageable);
}
