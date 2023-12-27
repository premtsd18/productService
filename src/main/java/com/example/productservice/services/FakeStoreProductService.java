package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDTO;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{
    RestTemplate restTemplate;

    private Product convertFakeStoreProductToProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product=new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImageUrl(fakeStoreProductDTO.getImage());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDTO.getCategory());
        return product;
    }
    @Override
    public Product getSingleProduct(Long id){
      FakeStoreProductDTO fakeStoreProductDTO=restTemplate.getForObject(
              "https://fakestoreapi.com/products/" + id,FakeStoreProductDTO.class);
      return convertFakeStoreProductToProduct(fakeStoreProductDTO);
    }
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
}
