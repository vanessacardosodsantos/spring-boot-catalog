package com.catalog.api.product;

import com.catalog.api.product.controller.ProductRequest;
import com.catalog.api.product.model.Product;
import com.catalog.api.product.repository.ProductRepository;
import com.catalog.api.product.service.ProductService;
import com.catalog.api.provider.ProviderRespository;
import com.catalog.api.provider.model.Provider;
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

public class ProductServiceTest {

    @Mock
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProviderRespository providerRespository;

    @BeforeEach
    public void setup() {
        openMocks(this);
        productService = new ProductService(productRepository, providerRespository);
    }

    @Nested
    @DisplayName("create product")
    class CreateProduct {

        @Test
        @DisplayName("should create product")
        void shouldCreateProduct() {
            ProductRequest requestProduct = new ProductRequest();
            Product productSaved = createProduct();
            Product request = request(requestProduct);
            given(productRepository.save(request)).willReturn(productSaved);

            Product result = productService.create(request);

            assertThat(result).isEqualTo(productSaved);
        }


    }

    public Product createProduct() {
        return new Product(1L,"celular", "celular de última geração",
                BigDecimal.valueOf(1400.00), BigDecimal.valueOf(50.00), List.of(provider()));
    }

    public Product request(ProductRequest request) {
        request.setName("Iphone");
        request.setDescription("Iphone 8 puls");
        request.setPrice(BigDecimal.valueOf(1500.00));
        request.setDiscount(BigDecimal.valueOf(100.00));
        request.setProvider(List.of(provider()));
        return new Product(request.getName(), request.getDescription(),request.getPrice(), request.getDiscount(), request.getProvider());
    }

    public Provider provider() {
        return new Provider("celular", "vanessacardoso@gmail.com");
    }
}
