package com.example.categories.seed;

import com.example.categories.repository.CategoryRepository;
import com.example.categories.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component("categorySeeder") // явне ім’я біну, щоб уникнути конфліктів
public class CategorySeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    // Конструктор вручну для інжекції залежностей
    public CategorySeeder(CategoryRepository categoryRepository, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) {

        // Перевірка, щоб не додавати категорії повторно
        if (categoryRepository.count() == 0) {

            categoryService.create(
                    "Electronics",
                    "https://picsum.photos/400/300?electronics"
            );

            categoryService.create(
                    "Clothing",
                    "https://picsum.photos/400/300?clothing"
            );

            categoryService.create(
                    "Books",
                    "https://picsum.photos/400/300?books"
            );

            System.out.println("Categories seeded successfully!");
        }
    }
}