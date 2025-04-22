package com.example.balo_center.module.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "delivery_addresses")
@Entity
public class DeliveryAddress {
    @Column(name = "id")
    @Id
    private String id;
    @Column(name = "delivery_name")
    private String deliveryName;
    @Column(name = "delivery_address")
    private String deliveryAddress;
    @Column(name = "delivery_phone")
    private String deliveryPhone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
