package com.catalog.api.provider.model;

import com.catalog.api.product.model.Product;
import lombok.Builder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "provider")
@Builder
public class Provider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    public Provider(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Provider(Provider provider) {
        this.id = provider.getId();
        this.name = provider.getName();
        this.email = provider.getEmail();
        this.product = provider.getProduct();
    }

    public Provider(Long id, String name, String email, Product product) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.product = product;
    }

    public Provider(String name, String email, Product product) {
        this.name = name;
        this.email = email;
        this.product = product;
    }

    public Provider(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Provider() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return Objects.equals(id, provider.id) && Objects.equals(name, provider.name) && Objects.equals(email, provider.email) && Objects.equals(product, provider.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, product);
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", product=" + product +
                '}';
    }
}
