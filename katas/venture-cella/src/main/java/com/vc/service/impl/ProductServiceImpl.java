package com.vc.service.impl;

import com.vc.model.Product;
import com.vc.model.dto.PaginationResponse;
import com.vc.model.dto.ProductDto;
import com.vc.repository.ProductRepository;
import com.vc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    public List<ProductDto> getByName(String name) {
        List<ProductDto> productDtos = new ArrayList<>();
        productRepository.getByName(name).forEach(product -> productDtos.add(product.toDto()));

        return productDtos;
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public PaginationResponse getAll(Integer page, Integer size) throws EntityNotFoundException {
        Page<Product> productPage = productRepository.findAll(
                PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name")));

        if (productPage.getContent().isEmpty()) throw new EntityNotFoundException();

        List<ProductDto> productDtos = new ArrayList<>();
        productPage.getContent().forEach(product -> productDtos.add(product.toDto()));

        return new PaginationResponse(page, productPage.getTotalPages(), productDtos);

    }

    @Override
    public List<ProductDto> getAll() {
        List<ProductDto> productDtos = new ArrayList<>();
        productRepository.findAll(Sort.by(Sort.Direction.ASC, "name")).forEach(product -> productDtos.add(product.toDto()));

        return productDtos;
    }

    @Override
    public void update(ProductDto productDto, Long id) throws EntityNotFoundException {
        if (productRepository.existsById(id)) {
            Product product = Product.fromDto(productDto);
            product.setId(id);
            productRepository.save(product);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
