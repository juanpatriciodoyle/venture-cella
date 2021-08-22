package com.vc.controller;

import com.vc.model.Product;
import com.vc.model.dto.ProductDto;
import com.vc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VentureCellaController implements VentureCellaApi {

    @Autowired
    private ProductService productService;

    @Override
    public void save(ProductDto productDto) {
        productService.save(productDto);
    }


    @Override
    public ResponseEntity<List<Product>> getByName(String name) {
        List<Product> productList = productService.getByName(name);
        if (productList.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productList);
    }

}
