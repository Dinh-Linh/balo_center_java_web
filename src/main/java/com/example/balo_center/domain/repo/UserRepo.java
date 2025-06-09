package com.example.balo_center.domain.repo;

import com.example.balo_center.domain.dto.UserFormDTO;
import com.example.balo_center.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long>,UserRepoCustom {
    Optional<User> findUsersByEmail(String email);
    boolean existsByEmail(String email);
    void deleteById(String id);
    User findById(String id);
}
