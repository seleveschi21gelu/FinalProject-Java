package org.example.controller;

import org.example.entity.*;
import org.example.repository.*;
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
    private PaidStatusRepository paidStatusRepository;


    @GetMapping
    private ResponseEntity<List<Invoice>> findAllInvoices() {
        List<InvoiceDTO> invoiceDTOS = invoiceService.findAllInvoices();

        return new ResponseEntity(invoiceDTOS, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    private ResponseEntity<InvoiceDTO> findInvoicesById(@PathVariable Integer id) {
        InvoiceDTO invoiceDTO = invoiceService.findInvoiceById(id);
        return new ResponseEntity<>(invoiceDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InvoiceDTO> addInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        invoiceDTO = invoiceService.addInvoice(invoiceDTO);
        return new ResponseEntity<>(invoiceDTO, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    private ResponseEntity<InvoiceDTO> updateInvoice(@PathVariable Integer id, @RequestBody InvoiceDTO invoiceDTO) {
        invoiceDTO.setId(id);
        invoiceService.updateInvoiceById(invoiceDTO);
        return new ResponseEntity<>(invoiceDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoiceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
