package com.vc.service;

import com.vc.model.dto.PaginationResponse;
import com.vc.model.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void save(ProductDto productDto);

    List<ProductDto> getByName(String name);

    void delete(Long id);

    PaginationResponse getAll(Integer page, Integer size);

    List<ProductDto> getAll();

    void update(ProductDto productDto, Long id);
}
