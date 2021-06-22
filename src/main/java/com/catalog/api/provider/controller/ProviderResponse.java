package com.catalog.api.provider.controller;

import com.catalog.api.provider.model.Provider;

import java.util.List;
import java.util.stream.Collectors;

public class ProviderResponse {

    private Long id;
    private String name;
    private String email;

    public ProviderResponse(Provider provider) {
        this.id = provider.getId();
        this.name = provider.getName();
        this.email = provider.getEmail();
    }

    public static List<ProviderResponse> listConvertProvider(List<Provider> providers) {
        return providers.stream().map(ProviderResponse::new).collect(Collectors.toList());
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
