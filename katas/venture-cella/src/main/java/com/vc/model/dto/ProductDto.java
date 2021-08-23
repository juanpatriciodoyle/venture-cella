package com.vc.model.dto;

public class ProductDto {

    String name;
    String description;
    Double price;
    Double weight;
    String country;

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

    public ProductDto(String name, String description, Double price, Double weight, String country) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.country = country;
    }

}