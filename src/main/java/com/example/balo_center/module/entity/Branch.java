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
@Table(name = "branches")
@Entity
public class Branch {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "branch_name")
    private String branchName;

    @PrePersist
    public void prePersist() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
