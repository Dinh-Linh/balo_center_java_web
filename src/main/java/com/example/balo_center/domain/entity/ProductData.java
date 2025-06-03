package com.example.balo_center.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name", length = 100, nullable = false)
    private String brandName;

    @Column(name = "name", length = 500, nullable = false)
    private String name;

    @Column(name = "price", length = 50)
    private String price;

    @Column(name = "image_link", columnDefinition = "TEXT")
    private String imageLink;

    @Column(name = "detail_link", columnDefinition = "TEXT")
    private String detailLink;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
