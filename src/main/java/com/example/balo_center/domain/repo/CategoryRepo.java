package com.example.balo_center.domain.repo;

import com.example.balo_center.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, String> {
    Category findByCategoryName(String name);
}
