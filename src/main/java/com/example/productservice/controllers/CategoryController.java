package com.example.productservice.controllers;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @GetMapping()
    public List<Category> getAllCategories(){
        return new ArrayList<Category>();
    }
    @GetMapping("/{category}")
    public List<Product> getAllProductsFromCategory(@PathVariable("category") String category){
        return new ArrayList<Product>();
    }
}
