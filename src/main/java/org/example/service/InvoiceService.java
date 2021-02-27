package org.example.service;

import org.example.entity.Invoice;
import org.example.entity.Situation;
import org.example.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice addInvoices(Invoice invoice) {
        return invoiceRepository.save(invoice);

    }

    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice findInvoiceById(Integer id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice by id " + id + " was not found"));
    }

    public Invoice updateInvoiceById(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoiceById(Integer id) {
        invoiceRepository.deleteById(id);
    }



}
