package org.example.controller;

import org.example.entity.*;
import org.example.repository.*;
import org.example.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bills")
public class InvoiceRestController {

    @Autowired
    private InvoiceService invoiceService;

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


    @GetMapping
    private ResponseEntity<List<Invoice>> findAllInvoices() {
        List<Invoice> bills = invoiceService.findAllInvoices();
        List<InvoiceDTO> invoiceDTOS = new ArrayList<>();
        for (Invoice invoice : bills) {
            invoiceDTOS.add(new InvoiceDTO(invoice.getId(), invoice.getInvoiceNumber(),
                    invoice.getMaterialAndExecution().getName(),
                    invoice.getProvider().getName(),
                    invoice.getInvoiceDate(),
                    invoice.getUnitPrice(),
                    invoice.getQuantity(),
                    invoice.getTva(),
                    invoice.getPaidStatus().getName(),
                    invoice.getClient().getName()));

        }
        return new ResponseEntity(invoiceDTOS, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<InvoiceDTO> findInvoiceById(@PathVariable Integer id) {
//    InvoiceDTO invoiceDTO = invoiceService.findInvoiceById(id);
//
//        return new ResponseEntity<>(invoiceDTO, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    private ResponseEntity<InvoiceDTO> findInvoicesById(@PathVariable Integer id) {
        Invoice invoice = invoiceService.findInvoiceById(id);
        InvoiceDTO invoiceDTO = new InvoiceDTO(invoice.getId(), invoice.getInvoiceNumber(),
                invoice.getMaterialAndExecution().getName(),
                invoice.getProvider().getName(),
                invoice.getInvoiceDate(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getTva(),
                invoice.getPaidStatus().getName(),
                invoice.getClient().getName());

        return new ResponseEntity<>(invoiceDTO, HttpStatus.OK);
    }

    //    @PostMapping
//    private Invoice addBills(@RequestBody Invoice invoice) {
//        InvoiceDTO invoiceDTO = new InvoiceDTO();
//
//        invoiceService.addInvoice(invoiceDTO);
//        return invoiceService.addBills(invoice);
//    }
    @PostMapping
    public Invoice addInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        MaterialAndExecution materialAndExecution = materialRepository.findByName(invoiceDTO.getMaterialAndExecution());
        Provider provider = providersRepository.findByName(invoiceDTO.getProvider());
        PaidStatus paidStatus = statusRepository.findByName(invoiceDTO.getPaidStatus());
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
        return invoiceRepository.save(invoice);
    }

//    @PostMapping
//    private ResponseEntity<InvoiceDTO> addInvoices(@RequestBody InvoiceDTO invoice) {
//        invoiceService.addInvoice(invoice);
//        return new ResponseEntity<>(invoice, HttpStatus.CREATED);
//    }

    @PutMapping("/{id}")
    private ResponseEntity<InvoiceDTO> updateInvoiceById(@PathVariable Integer id, @RequestBody InvoiceDTO invoiceDTO) {
        MaterialAndExecution materialAndExecution = materialRepository.findByName(invoiceDTO.getMaterialAndExecution());
        Provider provider = providersRepository.findByName(invoiceDTO.getProvider());
        PaidStatus paidStatus = statusRepository.findByName(invoiceDTO.getPaidStatus());
//        FlatBlock flatBlock = flatBlockRepository.findByName(invoiceDTO.getFlatblock());
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
        invoiceService.updateInvoiceById(invoice);
        return new ResponseEntity<>(invoiceDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoiceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
