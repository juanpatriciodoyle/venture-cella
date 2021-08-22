package com.vc.service;

import com.vc.model.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    void save(ProductDto productDto);

}
