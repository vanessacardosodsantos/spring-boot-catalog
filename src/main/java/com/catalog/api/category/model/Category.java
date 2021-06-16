package com.catalog.api.category.model;

import com.catalog.api.product.model.Product;
import org.springframework.data.annotation.Id;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE})
    @JoinColumn(name = "id_product")
    @Column
    private Product product;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
