package com.cogent.ecommerceminiproject.services;

import com.cogent.ecommerceminiproject.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCatId(Long catId);
    Product createProduct(Long catId, Product product);
    Product updateProduct(Product updateProduct);
    void deleteProduct(Long productId);
    Product getProductByID(Long id);
}
