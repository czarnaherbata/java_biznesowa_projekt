package com.example.forum.controllers;

import com.example.forum.models.Category;
import com.example.forum.services.categories.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl category;

    @GetMapping("/show")
    public String getItems(Model model, HttpServletRequest request) {
        System.out.println("get items in controller "+this.category.getAllCategories());

        model.addAttribute("categories",this.category.getAllCategories());
        return "categories";
    }

    @GetMapping("/add")
    public String manageCategory(Model model){
        model.addAttribute("categories", new Category());
        return "add_category";
    }
    @PostMapping("/add")
    public String managePost(@ModelAttribute("categories") Category newCategory, /*Errors*/ BindingResult result, Model model) {
        System.out.println("result "+result.hasErrors());
        if (result.hasErrors()) {
            System.out.println(result.getErrorCount());
            result.getAllErrors().forEach(el-> System.out.println(el));
            // model.addAttribute("categories",this.service.getCategories());
            return "add_category";
        }
        this.category.saveCategory(newCategory);
        return "redirect:/index/";
//
    }
}

