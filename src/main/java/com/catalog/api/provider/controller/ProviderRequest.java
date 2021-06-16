package com.catalog.api.provider.controller;

import com.catalog.api.provider.model.Provider;

public class ProviderRequest {

    private String name;
    private String email;

    public Provider to(){
        return new Provider(this.name, this.email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
