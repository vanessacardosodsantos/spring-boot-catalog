package com.catalog.api.category.service;

import com.catalog.api.category.controller.CategoryUpdateRequest;
import com.catalog.api.category.model.Category;
import com.catalog.api.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Category> findProductsByCategory(Long categoryId) {
        Optional<Category> categoryEntity = categoryRepository.findById(categoryId);
        return categoryEntity.stream().map(Category::new).collect(Collectors.toList());
    }

    public Category updateProductByCategory(Long categoryId, Long productId, CategoryUpdateRequest categoryUpdateRequest) throws Exception {
        Optional<Category> categoryEntity = categoryRepository.findByIdAndProductId(categoryId, productId);
        if (categoryEntity.isEmpty()) {
            throw new Exception();
        }
        categoryEntity.ifPresent(c -> {
            c.setName(categoryUpdateRequest.getName());
        });
        return categoryEntity.get();
    }

    public void delete(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
