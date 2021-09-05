package com.vc.controller;

import com.vc.model.dto.PaginationResponse;
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
    ResponseEntity<List<ProductDto>> getAll();

    @GetMapping("/products/byPage")
    ResponseEntity<PaginationResponse> getAll(@RequestParam Integer page, @RequestParam Integer size);

    @GetMapping("/products/name")
    ResponseEntity<List<ProductDto>> getByName(@RequestParam String name);
}
