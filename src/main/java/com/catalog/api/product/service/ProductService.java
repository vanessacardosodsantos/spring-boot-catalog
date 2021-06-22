package com.catalog.api.product.service;

import com.catalog.api.product.controller.ProductUpdateRequest;
import com.catalog.api.product.model.Product;
import com.catalog.api.product.repository.ProductRepository;
import com.catalog.api.provider.ProviderRespository;
import com.catalog.api.provider.controller.ProviderRequest;
import com.catalog.api.provider.model.Provider;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProviderRespository providerRespository;

    public ProductService(ProductRepository productRepository, ProviderRespository providerRespository) {
        this.productRepository = productRepository;
        this.providerRespository = providerRespository;
    }

    public Product create(Product request) {
        return productRepository.save(request);
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public List<Product> findProductsByProvider(Long providerId) {
        Optional<Product> products = productRepository.findByProviderId(providerId);
        return products.stream().map(Product::new).collect(Collectors.toList());
    }

    public List<Product> findByDiscont(Long discont) {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .filter(c -> c.getDiscount().compareTo(BigDecimal.valueOf(discont)) >= 1)
                .collect(Collectors.toList());
    }

    public Provider addProviderProduct(ProviderRequest request, Long productId) throws Exception {
        Product product = existById(productId);
        Provider provider = Provider.builder()
                .name(request.getName())
                .email(request.getEmail())
                .product(product)
                .build();
        return providerRespository.save(provider);
    }

    public Product existById(Long productId) throws Exception {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            throw new Exception();
        }
        return product.get();
    }

    public Product updateProduct(ProductUpdateRequest request, Long productId) {
        Optional<Product> productOpt = productRepository.findById(productId);
        productOpt.ifPresent(p -> {
            p.setName(request.getName());
            p.setDescription(request.getDescription());
            p.setPrice(request.getPrice());
            p.setDiscount(request.getDiscount());
            productRepository.save(p);
        });
        return productOpt.get();
    }
}
