package com.catalog.api.product.service;

import com.catalog.api.product.ProductRepository;
import com.catalog.api.product.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product request) {
        return productRepository.save(request);
    }
}
