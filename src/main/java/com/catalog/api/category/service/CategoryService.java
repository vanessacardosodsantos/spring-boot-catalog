package com.catalog.api.category.service;

import com.catalog.api.category.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category request) {
        return categoryRepository.save(request);
    }
}
