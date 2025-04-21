package com.example.balo_center.module.entity.repo;

import com.example.balo_center.module.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUsersByEmail(String email);
}
