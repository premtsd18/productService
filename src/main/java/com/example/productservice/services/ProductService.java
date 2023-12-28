package com.example.productservice.services;

import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);
    Product createProduct(Product product);
    List<Product> getAllProducts();
}


