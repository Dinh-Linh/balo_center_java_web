package com.example.balo_center.repository;

import com.example.balo_center.domain.entity.Branch;
import com.example.balo_center.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepo extends JpaRepository<Branch, Long> {
    Optional<Branch> findByBranchName(String branchName);
}

