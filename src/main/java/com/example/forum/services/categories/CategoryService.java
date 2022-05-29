package com.example.forum.services.categories;

import com.example.forum.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public Optional<Category> getCategoryById(Long id);

    public List<Category> getAllCategories();

    public Category saveCategory(Category category);

    public void deleteCategoryById(Long id);
}
