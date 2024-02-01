package com.example.productservice.services;

import com.example.productservice.models.Product;

import java.util.List;

public interface  ProductService {
    Product getSingleProduct(Long id) throws Exception;
    Product createProduct(Product product);
    List<Product> getAllProducts();

    Product updateProduct(Long id,Product product);
    Product replaceProduct(Long id,Product product);
}


