package org.example.controller;

import org.example.entity.*;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/invoicedto")
public class InvoiceDtoController {

    @Autowired
    private InvoiceDtoRepository invoiceDtoRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProvidersRepository providersRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    DeliveryTypeRepository deliveryTypeRepository;


    @GetMapping()
    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    @GetMapping("/{id}")
    public InvoiceDTO getInvoice(@PathVariable Integer id) {
        Invoice invoice = invoiceRepository.findById(id).get();

        InvoiceDTO invoiceDTO = new InvoiceDTO(invoice.getInvoiceNumber(),
                invoice.getMaterialAndExecution().getName(),
                invoice.getProvider().getName(),
                invoice.getInvoiceDate(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getTva(),
                invoice.getPaidStatus().getName(),
//                invoice.getFlatBlock().getName(),
                invoice.getClient().getName());
        invoiceDTO.setId(id);
        return invoiceDTO;

    }

    @PostMapping()
    public String addInvoice(@RequestBody InvoiceDTO invoiceDTO) {
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

        invoiceRepository.save(invoice);
        return "Success";

    }

    @PutMapping("/{id}")
    public String updateInvoiceById(@PathVariable Integer id, @RequestBody InvoiceDTO invoiceDTO) {
        MaterialAndExecution materialAndExecution = materialRepository.findByName(invoiceDTO.getMaterialAndExecution());
        Provider provider = providersRepository.findByName(invoiceDTO.getProvider());
        PaidStatus paidStatus = statusRepository.findByName(invoiceDTO.getPaidStatus());

        Client client = clientRepository.findByName(invoiceDTO.getClient());

        Invoice invoice = new Invoice();

        invoice.setId(id);
        invoice.setInvoiceNumber(invoiceDTO.getInvoiceNumber());
        invoice.setMaterialAndExecution(materialAndExecution);
        invoice.setProvider(provider);
        invoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        invoice.setUnitPrice(invoiceDTO.getUnitPrice());
        invoice.setQuantity(invoiceDTO.getQuantity());
        invoice.setTva(invoiceDTO.getTva());
        invoice.setPaidStatus(paidStatus);
//        invoice.setFlatBlock(flatBlock);
        invoice.setClient(client);

        return "Success!";

    }
    @DeleteMapping
    public String deleteInvoiceById(@PathVariable Integer id){
        invoiceRepository.deleteById(id);
        return "Success";
    }


}
