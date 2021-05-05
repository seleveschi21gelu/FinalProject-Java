package org.example.service;

import org.example.entity.*;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
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
    private PaidStatusRepository paidStatusRepository;
    @Autowired
    private DeliveryTypeRepository deliveryTypeRepository;


    public InvoiceDTO addInvoice(InvoiceDTO invoiceDTO) {
        Material material = materialRepository.findByName(invoiceDTO.getMaterialAndExecution());
        Provider provider = providersRepository.findByName(invoiceDTO.getProvider());
        PaidStatus paidStatus = paidStatusRepository.findByName(invoiceDTO.getPaidStatus());
        Client client = clientRepository.findByName(invoiceDTO.getClient());


        Invoice invoice = new Invoice(
                invoiceDTO.getInvoiceNumber(),
                material,
                provider,
                invoiceDTO.getInvoiceDate(),
                invoiceDTO.getUnitPrice(),
                invoiceDTO.getQuantity(),
                invoiceDTO.getTva(),
                paidStatus,
                client);

         invoiceRepository.save(invoice);
         return invoiceDTO;


    }

    public List<InvoiceDTO> findAllInvoices() {
        List<Invoice> invoicesList = invoiceRepository.findAll();
        List<InvoiceDTO> invoiceDTOList = new ArrayList<>();
        for (Invoice invoice : invoicesList) {
            invoiceDTOList.add(new InvoiceDTO(
                    invoice.getId(),
                    invoice.getInvoiceNumber(),
                    invoice.getMaterial().getName(),
                    invoice.getProvider().getName(),
                    invoice.getInvoiceDate(),
                    invoice.getUnitPrice(),
                    invoice.getQuantity(),
                    invoice.getTva(),
                    invoice.getPaidStatus().getName(),
                    invoice.getClient().getName()));
        }
        return invoiceDTOList;
    }

    public InvoiceDTO findInvoiceById(Integer id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("The invoice from id " + id + " was not found"));

        InvoiceDTO invoiceDTO = new InvoiceDTO(invoice.getId(),
                invoice.getInvoiceNumber(),
                invoice.getMaterial().getName(),
                invoice.getProvider().getName(),
                invoice.getInvoiceDate(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getTva(),
                invoice.getPaidStatus().getName(),
                invoice.getClient().getName());

        return invoiceDTO;

    }

    public InvoiceDTO updateInvoiceById(@RequestBody InvoiceDTO invoiceDTO) {
        Material material = materialRepository.findByName(invoiceDTO.getMaterialAndExecution());
        Provider provider = providersRepository.findByName(invoiceDTO.getProvider());
        PaidStatus paidStatus = paidStatusRepository.findByName(invoiceDTO.getPaidStatus());
        Client client = clientRepository.findByName(invoiceDTO.getClient());

        Invoice invoice = new Invoice();

        invoice.setId(invoiceDTO.getId());
        invoice.setInvoiceNumber(invoiceDTO.getInvoiceNumber());
        invoice.setMaterial(material);
        invoice.setProvider(provider);
        invoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        invoice.setUnitPrice(invoiceDTO.getUnitPrice());
        invoice.setQuantity(invoiceDTO.getQuantity());
        invoice.setTva(invoiceDTO.getTva());
        invoice.setPaidStatus(paidStatus);
        invoice.setClient(client);

        invoiceRepository.save(invoice);
        return invoiceDTO;
    }


    public void deleteInvoiceById(Integer id) {
        invoiceRepository.deleteById(id);
    }


}
