package com.example.forum.repositories;

import com.example.forum.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findCategoryEntityByName(String name);
}