package org.example.entity;

import org.example.entity.enums.Status;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String invoiceNumber;
    double unitPrice;
    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    Providers providers;
    Date invoiceDate;
    Status status;
    @ManyToOne
    @JoinColumn(name = "flatblock_id", referencedColumnName = "id")
    FlatBlock flatBlock;

    public Invoice(String invoiceNumber, double unitPrice, Providers providers, Date invoiceDate, Status status, FlatBlock flatBlock) {
        this.invoiceNumber = invoiceNumber;
        this.unitPrice = unitPrice;
        this.providers = providers;
        this.invoiceDate = invoiceDate;
        this.status = status;
        this.flatBlock = flatBlock;
    }

    public Invoice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Providers getProviders() {
        return providers;
    }

    public void setProviders(Providers providers) {
        this.providers = providers;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public FlatBlock getFlatBlock() {
        return flatBlock;
    }

    public void setFlatBlock(FlatBlock flatBlock) {
        this.flatBlock = flatBlock;
    }
}
