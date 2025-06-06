package com.example.balo_center.domain.repo;

import com.example.balo_center.domain.dto.ProductFormDTO;
import com.example.balo_center.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
    @Query("select new com.example.balo_center.domain.dto.ProductFormDTO(p.id, p.productName, c.categoryName, b.branchName, p.quality, p.sold, p.price, p.productShortDesc, p.productDetailDesc) " +
           "from Product p join p.category c join p.branch b " +
           "where (:searchName is null or p.productName like concat('%', :searchName, '%')) " +
           "and (:brand is null or b.branchName = :brand)")
    Page<ProductFormDTO> findAllProduct(@Param("searchName") String searchName, 
                                      @Param("brand") String brand, 
                                      Pageable pageable);

    @Query("select new com.example.balo_center.domain.dto.ProductFormDTO(" +
            "p.id, p.productName, c.categoryName, b.branchName, p.quality, p.sold, p.price, p.productShortDesc, p.productDetailDesc) " +
            "from Product p join p.category c join p.branch b " +
            "where p.id = :id")
    ProductFormDTO findProductById(@Param("id") String id);

    @Query("select p.image from Product p where p.id = :id")
    List<String> findProductImages(@Param("id") String id);

    void deleteById(@Param("id") String id);
}
