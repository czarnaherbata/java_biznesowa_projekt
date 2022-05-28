package com.example.forum.services.categories;

import com.example.forum.models.Category;

import java.util.List;

public interface CategoryService {

    public Category getCategoryById(Integer id);

    public List<Category> getAllCategories();

    public void deleteCategoryById(Integer id);

    public Category saveCategory(Category category);
}