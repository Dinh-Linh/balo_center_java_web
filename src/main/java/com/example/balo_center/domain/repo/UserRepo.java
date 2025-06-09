package com.example.balo_center.domain.repo;

import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.repo.custom.UserRepoCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long>, UserRepoCustom {
    Optional<User> findUsersByEmail(String email);
    boolean existsByEmail(String email);
    void deleteById(String id);
    User findById(String id);
}