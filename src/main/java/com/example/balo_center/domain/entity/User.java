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
@Table(name = "users")
@Entity
public class User {
    @Column(name = "id")
    @Id
    private String id;
    @Column(name = "email")
    private String email;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String userPhone;
    @Column(name = "role")
    private String role;
    @Column(name = "status")
    private String status;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DeliveryAddress> deliveryAddressList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orderList;

    @PrePersist
    public void prePersist() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }

}
