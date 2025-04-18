package com.example.balo_center.module.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String id;
    private String email;
    private String fullname;
    private String password;
    private String userPhone;
    private String role;
    private String status;
    private String avatar;
    private Timestamp createdDate;
}
