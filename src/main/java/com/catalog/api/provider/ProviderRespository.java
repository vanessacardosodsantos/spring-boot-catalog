package com.catalog.api.provider;

import com.catalog.api.provider.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRespository extends JpaRepository<Provider, Long> {
}
