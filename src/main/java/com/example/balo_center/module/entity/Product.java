package com.example.balo_center.module.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "products")
@Entity
public class Product {
    @Column(name = "id")
    @Id
    private String id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "detail_desc")
    private String productDetailDesc;
    @Column(name = "short_desc")
    private String productShortDesc;
    @Column(name = "quality")
    private Integer quality;
    @Column(name = "price")
    private Double price;
    @Column(name = "sold")
    private Integer sold;
    @Column(name = "images")
    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    private List<String> image;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Cart> carts;

    @PrePersist
    public void prePersist(){
        if(this.id == null || this.id.isEmpty()){
            this.id = UUID.randomUUID().toString();
        }
    }

}
