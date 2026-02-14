package com.example.categories.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "image_path")
    private String imagePath;

    // ====== constructors ======

    public Category() {
    }

    public Category(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    // ====== getters ======

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    // ====== setters ======

    public void setName(String name) {
        this.name = name;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}