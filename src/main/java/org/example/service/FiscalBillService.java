package org.example.service;

import org.example.entity.FiscalBill;
import org.example.entity.Invoice;
import org.example.repository.FiscalBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiscalBillService {

    @Autowired
    private FiscalBillRepository fiscalBillRepository;


    public FiscalBill addInvoices(FiscalBill fiscalBill) {
        return fiscalBillRepository.save(fiscalBill);
    }

    public List<FiscalBill> findAllInvoices() {
        return fiscalBillRepository.findAll();
    }

    public FiscalBill findInvoiceById(Integer id) {
        return fiscalBillRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice by id " + id + " was not found"));
    }

    public FiscalBill updateInvoiceById(FiscalBill invoice) {
        return fiscalBillRepository.save(invoice);
    }

    public void deleteInvoiceById(Integer id) {
        fiscalBillRepository.deleteById(id);
    }


}
