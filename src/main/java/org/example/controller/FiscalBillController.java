package org.example.controller;

import org.example.entity.FiscalBill;
import org.example.service.FiscalBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/fiscalBill")
public class FiscalBillController {

    @Autowired
    private FiscalBillService fiscalBillService;

    @GetMapping
    private ResponseEntity<List<FiscalBill>> findAllInvoices() {
        List<FiscalBill> bills = fiscalBillService.findAllInvoices();
        return new ResponseEntity(bills, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<FiscalBill> findInvoicesById(@PathVariable Integer id) {
        FiscalBill invoice = fiscalBillService.findInvoiceById(id);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<FiscalBill> addInvoices(@RequestBody FiscalBill fiscalBill) {
        fiscalBillService.addInvoices(fiscalBill);
        return new ResponseEntity<>(fiscalBill, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<FiscalBill> updateInvoiceById(@PathVariable Integer id, @RequestBody FiscalBill fiscalBill) {
        fiscalBill.setId(id);
        fiscalBillService.updateInvoiceById(fiscalBill);
        return new ResponseEntity<>(fiscalBill, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteInvoice(@PathVariable Integer id) {
        fiscalBillService.deleteInvoiceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
