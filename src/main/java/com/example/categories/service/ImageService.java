package com.example.categories.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.*;
import java.util.UUID;

@Service
public class ImageService {

    private final Path root = Paths.get("uploads/categories");

    public String saveFromUrl(String imageUrl) {
        try {
            Files.createDirectories(root);

            String fileName = UUID.randomUUID() + ".jpg";
            Path target = root.resolve(fileName);

            try (InputStream in = URI.create(imageUrl).toURL().openStream()) {
                Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
            }

            return target.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to save image", e);
        }
    }
}