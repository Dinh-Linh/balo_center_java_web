package com.example.balo_center.domain.entity.repo;

import com.example.balo_center.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByCategoryName(String name);
}
