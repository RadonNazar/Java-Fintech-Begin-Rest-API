package com.example.categories.service;

import com.example.categories.entity.Category;
import com.example.categories.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ImageService imageService;

    public CategoryService(CategoryRepository categoryRepository, ImageService imageService) {
        this.categoryRepository = categoryRepository;
        this.imageService = imageService;
    }

    public Category create(String name, String imageUrl) {
        if (categoryRepository.existsByName(name)) {
            throw new RuntimeException("Category already exists");
        }

        String imagePath = imageService.saveFromUrl(imageUrl);
        Category category = new Category(name, imagePath);
        return categoryRepository.save(category);
    }
}