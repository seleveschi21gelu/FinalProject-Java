package org.example.service;

import org.example.entity.*;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceDtoRepository invoiceDtoRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProvidersRepository providersRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private FlatBlockRepository flatBlockRepository;

    @Autowired
    DeliveryTypeRepository deliveryTypeRepository;


    public Invoice addInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        MaterialAndExecution materialAndExecution = materialRepository.findByName(invoiceDTO.getMaterialAndExecution());
        Provider provider = providersRepository.findByName(invoiceDTO.getProvider());
        PaidStatus paidStatus = statusRepository.findByName(invoiceDTO.getPaidStatus());
//        FlatBlock flatBlock = flatBlockRepository.findByName(invoiceDTO.getFlatblock());
        Client client = clientRepository.findByName(invoiceDTO.getClient());



        Invoice invoice = new Invoice(
                invoiceDTO.getInvoiceNumber(),
                materialAndExecution,
                provider,
                invoiceDTO.getInvoiceDate(),
                invoiceDTO.getUnitPrice(),
                invoiceDTO.getQuantity(),
                invoiceDTO.getTva(),
                paidStatus,
                client);

        invoice.setTotalWithoutTva(invoice.getTotalWithoutTva());
        invoice.setTotalWithTva(invoice.getTotalWithTva());

       return invoiceRepository.save(invoice);
//        return "Success";

    }

    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice findInvoiceById(Integer id) {
        Invoice invoice = new Invoice();
        invoice.setTotalWithoutTva(invoice.getTotalWithoutTva());
        invoice.setTotalWithTva(invoice.getTotalWithTva());
        invoiceRepository.save(invoice);
        return invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice by id " + id + " was not found"));
    }

    public Invoice updateInvoiceById(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoiceById(Integer id) {
        invoiceRepository.deleteById(id);
    }



}
