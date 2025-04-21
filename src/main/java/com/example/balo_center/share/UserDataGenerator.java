package com.example.balo_center.share;

import com.example.balo_center.module.entity.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDataGenerator {
    public static List<User> generateMockUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new
                    User(UUID.randomUUID().toString(),
                    "user" + i + "@gmail.com",
                    "Username" + i,
                    "password" + i,
                    "098235127" + i,
                    i % 2 == 0 ? "Admin" : "User",
                    i % 3 == 0 ? "Hoạt động" : "Khoá",
                    null,
                    new Timestamp(System.currentTimeMillis() - (i*8640000L)));
            users.add(user);
        }
        return users;
    }
    /*public static void main(String[] args) {
        List<User> mockUsers = generateMockUsers();
        for (User user : mockUsers) {
            System.out.println("ID: " + user.getId());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Fullname: " + user.getFullname());
            System.out.println("Phone: " + user.getUserPhone());
            System.out.println("Role: " + user.getRole());
            System.out.println("Status: " + user.getStatus());
            System.out.println("Avatar: " + user.getAvatar());
            System.out.println("Created: " + user.getCreatedDate());
            System.out.println("---------------------------");
        }
    }*/
}
