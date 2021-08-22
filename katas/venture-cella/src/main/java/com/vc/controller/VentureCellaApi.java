package com.vc.controller;

import com.vc.model.dto.ProductDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/venture-cella")
public interface VentureCellaApi {

    @PostMapping("/products")
    void save(@RequestBody ProductDto productDto);


}
