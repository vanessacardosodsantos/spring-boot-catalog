package com.catalog.api.provider.service;

import com.catalog.api.provider.model.Provider;
import com.catalog.api.provider.ProviderRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRespository providerRespository;

    public ProviderService(ProviderRespository providerRespository) {
        this.providerRespository = providerRespository;
    }

    public Provider create(Provider request) {
        return providerRespository.save(request);
    }


    public List<Provider> listAll() {
        return providerRespository.findAll();
    }
}
