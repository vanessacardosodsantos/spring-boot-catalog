package com.catalog.api.category.controller;

import com.catalog.api.category.model.Category;
import com.catalog.api.category.service.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponse createCategory(@RequestBody CategoryRequest request) {
        Category category = categoryService.create(new Category(request));
        return new CategoryResponse(category);
    }

    @GetMapping
    public List<CategoryResponse> list() {
        List<Category> categories = categoryService.listAll();
        return categories.stream().map(CategoryResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/product/{categoryId}")
    public List<CategoryResponse> listCategoryAndProducts(@PathVariable Long categoryId) {
        List<Category> categories = categoryService.findProductsByCategory(categoryId);
        return categories.stream().map(CategoryResponse::new).collect(Collectors.toList());
    }

    @PatchMapping("/product/{categoryId}/{productId}")
    public CategoryResponse updateCategoryByProduct(@PathVariable Long categoryId, @PathVariable Long productId, @RequestBody CategoryUpdateRequest categoryUpdateRequest) throws Exception {
        Category category = categoryService.updateProductByCategory(categoryId, productId, categoryUpdateRequest);
        return new CategoryResponse(category);
    }

    @DeleteMapping("/{categoryId}")
    public void delete(@PathVariable Long categoryId) {
        categoryService.delete(categoryId);
    }
}
