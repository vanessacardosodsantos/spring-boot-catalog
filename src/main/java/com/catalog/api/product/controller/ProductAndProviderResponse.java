package com.catalog.api.product.controller;

import com.catalog.api.provider.model.Provider;

public class ProductAndProviderResponse {

    private Long id;
    private String name;
    private String email;
    private Long product;

    public ProductAndProviderResponse(Provider provider) {
        this.id = provider.getId();
        this.name = provider.getName();
        this.email = provider.getEmail();
        this.product = provider.getProduct().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }
}
