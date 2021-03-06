package org.example.service;

import org.example.entity.Provider;
import org.example.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvidersService {

    @Autowired
    private ProvidersRepository providerRepository;

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Provider getProviderById(Integer id) {
        return providerRepository.findById(id).orElseThrow(() -> new RuntimeException("The provider to id " + id + " was not found"));
    }

    public Provider addProviders(Provider providers) {
        return providerRepository.save(providers);
    }

    public Provider updateProviderById(Provider providers) {
        return providerRepository.save(providers);
    }

    public void deleteProviderById(Integer id) {
        providerRepository.deleteById(id);
    }


}
