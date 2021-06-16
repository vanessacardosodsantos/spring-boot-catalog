package com.catalog.api.provider.controller;

import com.catalog.api.provider.model.Provider;

public class ProviderResponse {

    private Long id;
    private String name;
    private String email;

    public ProviderResponse(Provider provider) {
        this.id = provider.getId();
        this.name = provider.getName();
        this.email = provider.getEmail();
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
}
