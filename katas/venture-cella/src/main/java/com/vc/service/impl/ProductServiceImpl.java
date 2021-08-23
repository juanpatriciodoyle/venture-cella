package com.vc.service.impl;

import com.vc.model.Product;
import com.vc.model.dto.ProductDto;
import com.vc.repository.ProductRepository;
import com.vc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingRequestValueException;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
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

    @Override
    public void delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<Product> getAll(Integer page, Integer size) {
        if (size != null && size != 0 && page != null) {
            Page<Product> productPage = productRepository.findAll(
                    PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name")));
            return productPage.getContent();
        } else {
            return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        }
    }

    @Override
    public void update(ProductDto productDto, Long id) {
        if (productRepository.existsById(id)) {
            Product product = Product.fromDto(productDto);
            product.setId(id);
            productRepository.save(product);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
