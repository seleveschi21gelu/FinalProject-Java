package org.example.service;

import org.example.entity.Client;
import org.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    public Client findClientById(Integer id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client by id " + id + " was not found"));
    }

    public Client updateInvoiceById(Client invoice) {
        return clientRepository.save(invoice);
    }

    public void deleteInvoiceById(Integer id) {
        clientRepository.deleteById(id);
    }

}
