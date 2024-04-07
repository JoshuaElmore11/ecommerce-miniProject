package com.cogent.ecommerceminiproject.services.impl;

import com.cogent.ecommerceminiproject.entities.Category;
import com.cogent.ecommerceminiproject.entities.Product;
import com.cogent.ecommerceminiproject.exception.ResourceNotFoundException;
import com.cogent.ecommerceminiproject.repositories.CategoryRepository;
import com.cogent.ecommerceminiproject.repositories.ProductRepository;
import com.cogent.ecommerceminiproject.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category newCategory) {
        return categoryRepository.save(newCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
        categoryRepository.delete(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        Category updateCat = new Category();
        if (categoryOptional.isPresent()) {
            updateCat = categoryOptional.get();
            updateCat.setId(id);
            updateCat.setName(category.getName());
            updateCat.setImage(category.getImage());
        }

        return categoryRepository.save(updateCat);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long catId) {
        Category category = categoryRepository
                .findById(catId)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
        return category;
    }

}
