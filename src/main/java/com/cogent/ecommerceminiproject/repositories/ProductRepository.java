package com.cogent.ecommerceminiproject.repositories;

import com.cogent.ecommerceminiproject.entities.Category;
import com.cogent.ecommerceminiproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductByCategory(Category category);
}
