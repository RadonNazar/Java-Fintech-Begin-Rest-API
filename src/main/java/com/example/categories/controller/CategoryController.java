package com.example.categories.controller;

import com.example.categories.repository.CategoryRepository;
import com.example.categories.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    public CategoryController(CategoryRepository categoryRepository,
                              CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories";
    }

    @GetMapping("/create")
    public String createForm() {
        return "category-create";
    }

    @PostMapping("/create")
    public String create(@RequestParam String name,
                         @RequestParam String imageUrl) {

        categoryService.create(name, imageUrl);
        return "redirect:/categories";
    }
}