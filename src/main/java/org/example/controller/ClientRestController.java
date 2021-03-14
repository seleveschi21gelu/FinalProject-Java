package org.example.controller;

import org.example.entity.Client;
import org.example.entity.Invoice;
import org.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    private ResponseEntity<List<Invoice>> findAllClients() {
        List<Client> bills = clientService.findAllClient();
        return new ResponseEntity(bills, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Client> findClientsById(@PathVariable Integer id) {
        Client client = clientService.findClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Client> addClients(@RequestBody Client client) {
        clientService.addClient(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Client> updateInvoiceById(@PathVariable Integer id, @RequestBody Client client) {
        client.setId(id);
        clientService.updateInvoiceById(client);
        return new ResponseEntity<>(client, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteInvoice(@PathVariable Integer id) {
        clientService.deleteInvoiceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
