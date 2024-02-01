package com.example.productservice.controllers;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    CategoryService categoryService;
    @Autowired
    CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping()
    public List<Category> getAllCategories(){
//        System.out.println("check1");
        return categoryService.getAllCategories();
    }
    @GetMapping("/{category}")
    public List<Product> getAllProductsFromCategory(@PathVariable("category") String category){
        return null;
    }

//    @GetMapping("/{category_id}")
//    public Category getSingleCategory(@PathVariable("category_id") Long category_id){
//        return categoryService.getSingleCategory(category_id);
//    }
}
