package com.example.productservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Double price;
    @ManyToOne
//    @JsonManagedReference -- this can be commented and is working
//    @JoinColumn(name="category_id") -- this can be commented and is working
    private Category category;
    private String description;
    private String imageUrl;
}
