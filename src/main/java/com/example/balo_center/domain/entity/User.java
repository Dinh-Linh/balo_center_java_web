package com.example.balo_center.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Column(name = "id")
    @Id
    @UuidGenerator
    private String id;
    @Column(name = "email")
    private String email;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String userPhone;
    @Column(name = "role")
    private String role = "USER"; // Added default value
    @Column(name = "status")
    private String status;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DeliveryAddress> deliveryAddressList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Order> orderList;

    // Explicit getters for fields accessed by UserDetailsImpl
    // Lombok should generate these, but adding them explicitly can help if there's a build/Lombok issue.
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getFullName() { // Added for consistency if UserDetailsImpl needs it
        return fullName;
    }
}