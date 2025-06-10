package com.example.balo_center.repository;

import com.example.balo_center.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUsersByEmail(String email);
    boolean existsByEmail(String email);
}
