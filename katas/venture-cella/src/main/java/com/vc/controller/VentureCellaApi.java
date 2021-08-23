package com.vc.controller;

import com.vc.model.Product;
import com.vc.model.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/venture-cella")
public interface VentureCellaApi {

    @PostMapping("/products")
    void save(@RequestBody ProductDto productDto);

    @PutMapping("/products")
    ResponseEntity<String> update(@RequestBody ProductDto productDto, @RequestParam Long id);

    @DeleteMapping("/products")
    ResponseEntity<String> delete(@RequestParam Long id);

    @GetMapping("/products")
    ResponseEntity<List<Product>> getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size);

    @GetMapping("/products/name")
    ResponseEntity<List<Product>> getByName(@RequestParam String name);
}
