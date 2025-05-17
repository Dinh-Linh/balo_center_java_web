package com.example.balo_center.domain.repo;

import com.example.balo_center.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUsersByEmail(String email);
    boolean existsByEmail(String email);

}
