package com.catalog.api.product.model;

import com.catalog.api.product.controller.ProductRequest;
import com.catalog.api.provider.model.Provider;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private BigDecimal price;
    @Column
    private BigDecimal discount;
    @Column
    private Long category_id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "product_id")
    private List<Provider> provider;

    public Product(ProductRequest request) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.price = request.getPrice();
        this.discount = request.getDiscount();
        this.provider = request.getProvider().stream().map(Provider::new).collect(Collectors.toList());
    }

    public Product(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.discount = product.getDiscount();
        this.provider = product.getProvider();
    }

    public Product(Long id, String name, String description, BigDecimal price, BigDecimal discount, Long category_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.category_id = category_id;
    }

    public Product(Long id, String name, String description, BigDecimal price, BigDecimal discount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    public Product(String name, String description, BigDecimal price, BigDecimal discount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    public Product(Long id, String name, String description, BigDecimal price, BigDecimal discount, Provider provider) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    public Product(String name, String description, BigDecimal price, BigDecimal discount, List<Provider> provider) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.provider = provider;
    }

    public Product(Long productId) {
        this.id = productId;
    }

    public Product(Long id, String name, String description, BigDecimal price, BigDecimal discount, List<Provider> provider) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.provider = provider;
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

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public void setProvider(List<Provider> provider) {
        this.provider = provider;
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

    public Long getCategory_id() {
        return category_id;
    }

    public List<Provider> getProvider() {
        return provider;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(discount, product.discount) && Objects.equals(category_id, product.category_id) && Objects.equals(provider, product.provider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, discount, category_id, provider);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", category_id=" + category_id +
                ", provider=" + provider +
                '}';
    }
}
