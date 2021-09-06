package com.vc.model;

import com.vc.model.dto.ProductDto;

import javax.persistence.*;

@Entity
@Table(indexes = @Index(columnList = "name"))
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
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getWeight(),
                productDto.getCountry()
        );
    }

    public ProductDto toDto() {
        return new ProductDto(this.getId(), this.getName(), this.getDescription(), this.getPrice(), this.getWeight(), this.getCountry());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
