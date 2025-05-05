package com.example.balo_center.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "address")
    private String address;
    @Column(name = "date")
    private Timestamp date;
    @Column(name = "phone")
    private String phone;
    @Column(name = "quality_product")
    private Integer quality_product;
    @Column(name = "total_price")
    private Double total_price;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @PrePersist
    public void prePersist() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
