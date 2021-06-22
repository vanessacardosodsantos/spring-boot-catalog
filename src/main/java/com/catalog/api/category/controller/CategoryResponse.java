package com.catalog.api.category.controller;

import com.catalog.api.category.model.Category;
import com.catalog.api.product.controller.ProductResponse;

import java.util.List;

public class CategoryResponse {

    private Long id;
    private String name;
    private List<ProductResponse> products;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.products = ProductResponse.listConvertProduct(category.getProduct());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }
}
