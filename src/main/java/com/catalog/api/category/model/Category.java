package com.catalog.api.category.model;

import com.catalog.api.category.controller.CategoryRequest;
import com.catalog.api.product.model.Product;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private List<Product> product;

    public Category(CategoryRequest request) {
        this.name = request.getName();
        this.product = request.getProduct().stream().map(Product::new).collect(Collectors.toList());
    }

    public Category(String name, List<Product> products) {
        this.name = name;
        this.product = products;
    }

    public Category() {
    }

    public Category(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.product = category.getProduct();
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(Long id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.product = products;
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

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product=" + product +
                '}';
    }
}
