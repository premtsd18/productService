package com.example.productservice.repositories;

import com.example.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    public Optional<Category> getCategoryById(Long id);
    public List<Category> getAllBy();
    public Category save(Category category);

    public  Optional<Category> getCategoryByNameContainingIgnoreCase(String name);

}
