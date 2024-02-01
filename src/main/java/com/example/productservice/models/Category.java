package com.example.productservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy="category")
    private List<Product> products;
}
