package com.catalog.api.product.controller;

import com.catalog.api.product.model.Product;
import com.catalog.api.provider.controller.ProviderResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal discount;
    private List<ProviderResponse> providers;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.discount = product.getDiscount();
        this.providers = ProviderResponse.listConvertProvider(product.getProvider());
    }

    public static List<ProductResponse> listConvertProduct(List<Product> products) {
        return products.stream().map(a -> new ProductResponse(a.getId(), a.getName(), a.getDescription(), a.getPrice(), a.getDiscount()
        )).collect(Collectors.toList());
    }

    public ProductResponse(Long id, String name, String description, BigDecimal price, BigDecimal discount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public List<ProviderResponse> getProviders() {
        return providers;
    }

    public void setProviders(List<ProviderResponse> providers) {
        this.providers = providers;
    }
}
