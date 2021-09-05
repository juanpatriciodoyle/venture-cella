package com.vc.controller;

import com.vc.model.dto.PaginationResponse;
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
    public ResponseEntity<List<ProductDto>> getByName(String name) {
        List<ProductDto> productList = productService.getByName(name);
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
    public ResponseEntity<List<ProductDto>> getAll() {

        List<ProductDto> productDtos = productService.getAll();

        if (productDtos.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(productDtos);
    }

    @Override
    public ResponseEntity<PaginationResponse> getAll(Integer page, Integer size) {
        if (size == null || size == 0 || page == null) {
            return ResponseEntity.badRequest().build();
        }

        try {
            PaginationResponse paginationResponse = productService.getAll(page, size);
            return ResponseEntity.ok(paginationResponse);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();

        }
    }

}
