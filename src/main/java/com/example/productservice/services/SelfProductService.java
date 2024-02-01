package com.example.productservice.services;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

@Autowired
    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
    this.categoryRepository=categoryRepository;
    this.productRepository=productRepository;
}
    @Override
    public Product getSingleProduct(Long id) throws Exception{
        Optional<Product> optionalProduct=productRepository.getProductById(id);
            if(optionalProduct.isEmpty()==true) {
                throw new Exception("Product Not Exist Exception");
            }
        return optionalProduct.get();
    }

    @Override
    public Product createProduct(Product product) {
        Optional<Category> categoryOptional=categoryRepository.getCategoryByNameContainingIgnoreCase(product.getCategory().getName());
        if(categoryOptional.isEmpty()) product.setCategory(null);
        else product.setCategory(categoryOptional.get());
        return productRepository.save(product);
}

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllBy();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
