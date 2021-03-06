package com.vc.model.dto;

public class ProductDto {

    Long id;
    String name;
    String description;
    Double price;
    Double weight;
    String country;

    private ProductDto() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Double getWeight() {
        return weight;
    }

    public String getCountry() {
        return country;
    }

    public Long getId() {
        return id;
    }

    public ProductDto(String name, String description, Double price, Double weight, String country) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.country = country;
    }

    public ProductDto(Long id, String name, String description, Double price, Double weight, String country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.country = country;
    }
}