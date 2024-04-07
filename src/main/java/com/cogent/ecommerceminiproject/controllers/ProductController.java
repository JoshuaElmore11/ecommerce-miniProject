package com.cogent.ecommerceminiproject.controllers;

import com.cogent.ecommerceminiproject.entities.Product;
import com.cogent.ecommerceminiproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long id) {
        var data = productService.getProductsByCatId(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        var data = productService.getProductByID(id);
        if(data == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/{catId}")
    public ResponseEntity<Product> createProduct(@RequestBody Product product, @PathVariable Long catId){
        var data = productService.createProduct(catId,product);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }
}
