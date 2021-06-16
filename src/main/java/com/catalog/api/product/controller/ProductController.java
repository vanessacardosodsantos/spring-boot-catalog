package com.catalog.api.product.controller;

import com.catalog.api.category.controller.CategoryResponse;
import com.catalog.api.category.model.Category;
import com.catalog.api.product.model.Product;
import com.catalog.api.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ProductResponse createProduct(@RequestBody ProductRequest request){
        Product productSaved = productService.create(request.to());
        return new ProductResponse(productSaved);
    }

    @GetMapping
    public List<ProductResponse> list(){
        List<Product> products = productService.listAll();
        return products.stream().map(ProductResponse::new).collect(Collectors.toList());
    }

}
