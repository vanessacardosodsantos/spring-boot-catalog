package com.catalog.api.category.controller;

import com.catalog.api.category.model.Category;

public class CategoryRequest {

    private String name;

    public Category to() {
        return new Category(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
