package com.vc.controller;

import com.vc.model.Product;
import com.vc.model.dto.ProductDto;
import com.vc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
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
    public ResponseEntity<String> update(ProductDto productDto, Long id) {
        try {
            productService.update(productDto, id);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<List<Product>> getByName(String name) {
        List<Product> productList = productService.getByName(name);
        if (productList.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productList);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        try {
            productService.delete(id);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

}
