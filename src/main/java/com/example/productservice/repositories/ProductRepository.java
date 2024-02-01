package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public Product save(Product product);
    public List<Product> getAllBy();
    public Optional<Product> getProductById(Long id);

    public void deleteById(Long id);

}
