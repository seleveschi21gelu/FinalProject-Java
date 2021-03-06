package org.example.controller;

import org.example.entity.Provider;
import org.example.service.ProvidersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProvidersService providerService;

    @GetMapping
    private ResponseEntity<List<Provider>> getAllProviders() {
        List<Provider> list = providerService.getAllProviders();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Provider> getProviderById(@PathVariable Integer id) {
        Provider provider = providerService.getProviderById(id);
        return new ResponseEntity<>(provider, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Provider> addProvider(@RequestBody Provider provider) {
        providerService.addProviders(provider);
        return new ResponseEntity<>(provider, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Provider> updateProvidersById(@PathVariable Integer id, @RequestBody Provider providers) {
        providers.setId(id);
        providerService.updateProviderById(providers);
        return new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Provider> deleteProvidersById(@PathVariable Integer id) {
        providerService.deleteProviderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
