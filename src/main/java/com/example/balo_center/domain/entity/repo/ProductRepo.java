package com.example.balo_center.domain.entity.repo;

import com.example.balo_center.domain.dto.ProductDTO;
import com.example.balo_center.domain.dto.ProductFormDTO;
import com.example.balo_center.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
    @Query("select new com.example.balo_center.domain.dto.ProductDTO(p.id, p.productName, c.categoryName, b.branchName, p.quality, p.sold, p.price, p.productShortDesc)" + "from Product p join p.category c join p.branch b")
    List<ProductDTO> findAllProduct();

    @Query("select new com.example.balo_center.domain.dto.ProductFormDTO(" +
            "p.id, p.productName, c.categoryName, b.branchName, p.quality, p.sold, p.price, p.productShortDesc, p.productDetailDesc) " +
            "from Product p join p.category c join p.branch b " +
            "where p.id = :id")
    ProductFormDTO findProductById(@Param("id") String id);

    void deleteById(@Param("id") String id);

}
