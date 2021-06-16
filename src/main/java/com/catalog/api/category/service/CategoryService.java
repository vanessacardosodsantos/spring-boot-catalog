package com.catalog.api.category.service;

import com.catalog.api.category.model.Category;
import com.catalog.api.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category request) {
        return categoryRepository.save(request);
    }

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }
}
