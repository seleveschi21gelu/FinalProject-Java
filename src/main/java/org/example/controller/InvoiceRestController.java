package org.example.controller;

import org.example.entity.Invoice;
import org.example.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bills")
public class InvoiceRestController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    private ResponseEntity<List<Invoice>> findAllInvoices() {
        List<Invoice> bills = invoiceService.findAllInvoices();
        return new ResponseEntity(bills, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Invoice> findInvoicesById(@PathVariable Integer id) {
        Invoice invoice = invoiceService.findInvoiceById(id);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Invoice> addInvoices(@RequestBody Invoice invoice) {
        invoiceService.addInvoices(invoice);
        return new ResponseEntity<>(invoice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Invoice> updateInvoiceById(@PathVariable Integer id, @RequestBody Invoice invoice) {
        invoice.setId(id);
        invoiceService.updateInvoiceById(invoice);
        return new ResponseEntity<>(invoice, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoiceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
