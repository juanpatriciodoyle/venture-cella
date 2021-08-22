package com.vc.service.impl;

import com.vc.model.Product;
import com.vc.model.dto.ProductDto;
import com.vc.repository.ProductRepository;
import com.vc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(ProductDto productDto) {
        productRepository.save(Product.fromDto(productDto));
    }

    @Override
    public List<Product> getByName(String name) {
        return productRepository.getByName(name);
    }
}
