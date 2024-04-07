package com.cogent.ecommerceminiproject.services.impl;

import com.cogent.ecommerceminiproject.entities.Category;
import com.cogent.ecommerceminiproject.entities.Product;
import com.cogent.ecommerceminiproject.repositories.CategoryRepository;
import com.cogent.ecommerceminiproject.repositories.ProductRepository;
import com.cogent.ecommerceminiproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCatId(Long catId) {
        Optional<Category> categoryOpt = categoryRepository.findById(catId);
        Category category = new Category();
        if(categoryOpt.isPresent()){
            category = categoryOpt.get();
        }
        return productRepository.getProductByCategory(category);
    }

    @Override
    public Product createProduct(Long catId, Product product) {
        Optional<Category> category = categoryRepository.findById(catId);

        if(category.isPresent()){
            product.setCategory(category.get());
            return productRepository.save(product);
        } else{
            throw new RuntimeException("Unable to create");
        }
    }

    @Override
    public Product updateProduct(Product updateProduct) {
        Product product = productRepository.findById(updateProduct
                .getId())
                .orElseThrow(() -> new RuntimeException("Resource not found"));
        product.setName(updateProduct.getName());
        product.setDescription(updateProduct.getDescription());
        product.setPrice(updateProduct.getPrice());
        product.setCategory(updateProduct.getCategory());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository
                .findById(productId).orElseThrow(() -> new RuntimeException("Resource not found"));
        productRepository.delete(product);
    }

    @Override
    public Product getProductByID(Long id) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
        return product;
    }

}
