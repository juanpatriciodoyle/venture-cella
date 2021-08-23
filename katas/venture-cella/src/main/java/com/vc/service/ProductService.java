package com.vc.service;

import com.vc.model.Product;
import com.vc.model.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void save(ProductDto productDto);

    List<Product> getByName(String name);

    void delete(Long id);

    List<Product> getAll(Integer page, Integer size);

    void update(ProductDto productDto, Long id);
}
