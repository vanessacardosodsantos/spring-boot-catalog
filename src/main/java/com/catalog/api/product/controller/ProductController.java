package com.catalog.api.product.controller;

import com.catalog.api.product.model.Product;
import com.catalog.api.product.service.ProductService;
import com.catalog.api.provider.controller.ProviderRequest;
import com.catalog.api.provider.model.Provider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest request) {
        Product productSaved = productService.create(new Product(request));
        return new ProductResponse(productSaved);
    }

    @PutMapping("/{productId}")
    public ProductResponse updateProduct(@RequestBody ProductUpdateRequest request, @PathVariable Long productId) {
        Product productSaved = productService.updateProduct(request, productId);
        return new ProductResponse(productSaved);
    }

    @GetMapping
    public List<ProductResponse> list() {
        List<Product> products = productService.listAll();
        return products.stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{providerId}")
    public List<ProductResponse> listByProvider(@PathVariable Long providerId) {
        List<Product> products = productService.findProductsByProvider(providerId);
        return products.stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/discount/{discount}")
    public List<ProductResponse> listByDiscont(@PathVariable Long discount) {
        List<Product> products = productService.findByDiscont(discount);
        return products.stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PutMapping("/provider/{productId}")
    public ProductAndProviderResponse addProviderToProduct(@PathVariable Long productId, @RequestBody ProviderRequest request) throws Exception {
        Provider providerAddInProduct = productService.addProviderProduct(request, productId);
        return new ProductAndProviderResponse(providerAddInProduct);
    }

}
