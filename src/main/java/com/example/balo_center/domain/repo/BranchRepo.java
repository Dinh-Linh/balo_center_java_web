package com.example.balo_center.domain.entity.repo;

import com.example.balo_center.domain.entity.Branch;
import com.example.balo_center.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch, Long> {
    Branch findByBranchName(String branchName);
}

