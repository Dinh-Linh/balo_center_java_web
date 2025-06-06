package com.example.balo_center.domain.repo;

import com.example.balo_center.domain.entity.Branch;
import com.example.balo_center.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch, String> {
    Branch findByBranchName(String branchName);
}
