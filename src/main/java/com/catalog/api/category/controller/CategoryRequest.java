package com.catalog.api.category.controller;

import com.catalog.api.product.model.Product;

import java.util.List;

public class CategoryRequest {

    private String name;
    private List<Product> product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }


}
