package com.example.forum.repositories;

import com.example.forum.models.Category;
import com.example.forum.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("FROM Category u WHERE u.active = true")
    public List<Category> getActiveCategories();
}
