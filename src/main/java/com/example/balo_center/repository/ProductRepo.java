package com.example.balo_center.repository;

import com.example.balo_center.domain.dto.response.ProductFormResponseDTO;
import com.example.balo_center.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
    @Query(value = "select new com.example.balo_center.domain.dto.response.ProductFormResponseDTO" +
            "(p.id, p.productName, c.categoryName, b.branchName, p.quality, p.sold, p.price, p.productShortDesc, p.productDetailDesc)" +
            "from Product p join p.category c join p.branch b")
    List<ProductFormResponseDTO> findAllProduct();

    @Query("select new com.example.balo_center.domain.dto.response.ProductFormResponseDTO" +
            "(p.id, p.productName, c.categoryName, b.branchName, p.quality, p.sold, p.price, p.productShortDesc, p.productDetailDesc) " +
            "from Product p join p.category c join p.branch b " +
            "where p.id = :id")
    ProductFormResponseDTO findProductById(@Param("id") String id);

    void deleteById(@Param("id") String id);

}
