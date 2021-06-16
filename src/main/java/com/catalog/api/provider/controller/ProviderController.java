package com.catalog.api.provider.controller;

import com.catalog.api.provider.model.Provider;
import com.catalog.api.provider.service.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping
    public ProviderResponse createCategory(@RequestBody ProviderRequest request) {
        Provider provider = providerService.create(request.to());
        return new ProviderResponse(provider);
    }

    @GetMapping
    public List<ProviderResponse> list() {
        List<Provider> providers = providerService.listAll();
        return providers.stream().map(ProviderResponse::new).collect(Collectors.toList());
    }
}
