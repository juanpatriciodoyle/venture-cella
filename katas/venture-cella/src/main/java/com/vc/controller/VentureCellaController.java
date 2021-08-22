package com.vc.controller;

import com.vc.model.dto.ProductDto;
import com.vc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentureCellaController implements VentureCellaApi {

    @Autowired
    private ProductService productService;

    @Override
    public void save(ProductDto productDto) {
        productService.save(productDto);
    }


}
