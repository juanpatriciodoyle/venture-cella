package com.vc.model;

import com.vc.model.dto.ProductDto;

import javax.persistence.*;

@Entity
@Table(indexes = {
        @Index(columnList = "name"),
        @Index(name = "country", columnList = "country")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Double weight;
    private String country;

    public Product(String name, String description, Double price, Double weight, String country) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.country = country;
    }

    public Product(Long id, String name, String description, Double price, Double weight, String country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.country = country;
    }

    public Product() {
    }


    public static Product fromDto(ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getWeight(),
                productDto.getCountry()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setCountry(String country) {
        this.country = country;
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
}
