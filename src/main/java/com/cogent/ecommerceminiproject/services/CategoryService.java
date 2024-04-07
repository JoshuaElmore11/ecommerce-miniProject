package com.cogent.ecommerceminiproject.services;

import com.cogent.ecommerceminiproject.entities.Category;
import com.cogent.ecommerceminiproject.entities.Product;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Long catId);

    Category createCategory(Category newCategory);

    Category updateCategory(Long catId, Category category);

    void deleteCategory(Long catId);
}
