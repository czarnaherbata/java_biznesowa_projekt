package com.example.forum.controllers.admin;

import com.example.forum.models.Category;
import com.example.forum.services.categories.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String allCategories(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/categories/index";
    }

    @GetMapping("/new")
    public String newCategory(Model model){
        model.addAttribute("category", new Category());
        model.addAttribute("method", "POST");
        return "admin/categories/form";
    }

    @PostMapping
    public String saveCategory(@ModelAttribute("category") Category category, Model model){
        categoryService.saveCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit/{id}")
    public String updateCategory(@PathVariable(value="id") Long id, Model model){
        Category category = categoryService.getCategoryById(id).isPresent()?categoryService.getCategoryById(id).get():new Category();
        model.addAttribute("category", category);
        model.addAttribute("method", "PUT");
        return "admin/categories/form";
    }

    @PutMapping("/categories")
    public String updateCategory(@ModelAttribute("category") Category category,Model model){
        categoryService.saveCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable(value="id") Long id, Model model){
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }
}
