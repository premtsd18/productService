package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    @Autowired
    ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService=productService;
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) throws Exception{
        return productService.getSingleProduct(id);
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        System.out.println("product.toString()");
        System.out.println(product.toString());
        return productService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.replaceProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        return;
    }
}
