package com.example.productservice.services;


import com.example.productservice.dtos.FakeStoreProductDTO;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

import static io.netty.handler.codec.rtsp.RtspHeaderValues.TIMEOUT;

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

    private FakeStoreProductDTO convertProductToFakeStoreProduct(Product product){
        FakeStoreProductDTO fakeStoreProductDTO=new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImageUrl());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setTitle(product.getTitle());
        return fakeStoreProductDTO;
    }
    @Override
    public Product getSingleProduct(Long id){
      FakeStoreProductDTO fakeStoreProductDTO=restTemplate.getForObject(
              "https://fakestoreapi.com/products/" + id,FakeStoreProductDTO.class);
      return convertFakeStoreProductToProduct(fakeStoreProductDTO);
    }

    @Override
    public Product createProduct(Product product){
        FakeStoreProductDTO fakeStoreProductDTO=convertProductToFakeStoreProduct(product);
        fakeStoreProductDTO=restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDTO,FakeStoreProductDTO.class);
        return  convertFakeStoreProductToProduct(fakeStoreProductDTO);
    }
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }


    @Override
    public List<Product> getAllProducts(){
        ArrayList<Product> listProduct=new ArrayList<>();
        FakeStoreProductDTO listProductDTO[] = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDTO[].class);
        listProduct.add(convertFakeStoreProductToProduct(listProductDTO[0]));
        listProduct.add(convertFakeStoreProductToProduct(listProductDTO[1]));
        return  listProduct;
    }

    @Override
    public Product updateProduct(Long id,Product product){
        String url="https://fakestoreapi.com/products/" + id;
        RequestCallback requestCallback = restTemplate.httpEntityCallback(convertProductToFakeStoreProduct(product), FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor<>(FakeStoreProductDTO.class, restTemplate.getMessageConverters());

        FakeStoreProductDTO response= restTemplate.execute(url, HttpMethod.PATCH, requestCallback, responseExtractor);
        return convertFakeStoreProductToProduct(response);

    }

    @Override
    public Product replaceProduct(Long id,Product product){
        return new Product();
    }
}
