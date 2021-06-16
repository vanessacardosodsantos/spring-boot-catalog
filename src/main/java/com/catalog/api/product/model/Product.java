package com.catalog.api.product.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

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

    public Product(String name, String description, BigDecimal price, BigDecimal discount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
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

    public Product() {
    }
}
