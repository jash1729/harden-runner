package com.poc.owasp.injection.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String category;
    private Double price;

    public Product() {}

    public Product(String name, String category, Double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getCategory() { return category; }

    public Double getPrice() { return price; }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setCategory(String category) { this.category = category; }

    public void setPrice(Double price) { this.price = price; }
}