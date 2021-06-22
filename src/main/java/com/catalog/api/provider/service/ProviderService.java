package com.catalog.api.provider.service;

import com.catalog.api.provider.ProviderRespository;
import com.catalog.api.provider.controller.ProviderRequest;
import com.catalog.api.provider.model.Provider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Provider update(Long providerId, ProviderRequest request) {
        Optional<Provider> providerOpt = providerRespository.findById(providerId);
        providerOpt.ifPresent(p -> {
            p.setName(request.getName());
            p.setEmail(request.getEmail());
            providerRespository.save(p);
        });
        return providerOpt.get();
    }

    public void delete(Long providerId) {
        providerRespository.deleteById(providerId);
    }
}
