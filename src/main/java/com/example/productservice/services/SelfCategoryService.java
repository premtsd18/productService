package com.example.productservice.services;

import com.example.productservice.models.Category;
import com.example.productservice.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SelfCategoryService implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public SelfCategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Category getSingleCategory(Long id) {
        Optional<Category> optionalCategory= categoryRepository.getCategoryById(id);
        if(optionalCategory.isEmpty()){
            return new Category();
        }
        return optionalCategory.get();
    }

    @Override
    public List<Category> getAllCategories() {
//        System.out.println("check");
        return categoryRepository.getAllBy();
    }

    public Category createCategory(Category category) throws Exception{
//        Optional<Category> optionalCategory=categoryRepository.save(category);
//        if(optionalCategory.isEmpty()) throw new Exception("Category not created");
        return categoryRepository.save(category);
    }
}
