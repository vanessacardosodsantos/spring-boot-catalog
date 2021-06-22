package com.catalog.api.category;

import com.catalog.api.category.controller.CategoryRequest;
import com.catalog.api.category.model.Category;
import com.catalog.api.category.repository.CategoryRepository;
import com.catalog.api.category.service.CategoryService;
import com.catalog.api.product.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.openMocks;

public class CategoryServiceTest {
    @Mock
    private CategoryService categoryService;
    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setup() {
        openMocks(this);
        categoryService = new CategoryService(categoryRepository);
    }

    @Nested
    @DisplayName("create category")
    class CreateCategory {

        @Test
        @DisplayName("should create category")
        void shouldCreateCategory() {
            CategoryRequest requestCategory = new CategoryRequest();
            Category categorySaved = createCategory();
            Category request = request(requestCategory);
            given(categoryRepository.save(request)).willReturn(categorySaved);

            Category result = categoryService.create(request);

            assertThat(result).isEqualTo(categorySaved);
        }
    }

    private Category createCategory() {
        return new Category(1L, "Eletrônicos", List.of(product()));
    }

    public Category request(CategoryRequest request) {
        request.setName("Eletrônicos");
        request.setProduct(List.of(product()));
        return new Category(request.getName(), request.getProduct());
    }

    public Product product() {
        return new Product("celular", "celular de última geração",
                BigDecimal.valueOf(1400.00), BigDecimal.valueOf(50.00));
    }
}
