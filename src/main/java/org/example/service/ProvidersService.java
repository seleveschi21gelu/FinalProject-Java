package org.example.service;

import org.example.entity.Providers;
import org.example.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.util.List;

@Service
public class ProvidersService {

    @Autowired
    private ProvidersRepository providerRepository;

    public List<Providers> getAllProviders() {
        return providerRepository.findAll();
    }

    public Providers getProviderById(Integer id) {
        return providerRepository.findById(id).orElseThrow(() -> new RuntimeException("The provider to id " + id + " was not found"));
    }

    public Providers addProviders(Providers providers) {
        return providerRepository.save(providers);
    }

    public Providers updateProviderById(Providers providers) {
        return providerRepository.save(providers);
    }

    public void deleteProviderById(Integer id) {
        providerRepository.deleteById(id);
    }


}
