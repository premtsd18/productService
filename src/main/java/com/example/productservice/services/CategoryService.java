package com.example.productservice.services;

import com.example.productservice.models.Category;

import java.util.List;

public interface CategoryService {
    public Category getSingleCategory(Long id);
    public List<Category> getAllCategories();
}
