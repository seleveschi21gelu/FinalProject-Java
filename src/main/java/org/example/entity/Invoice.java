package org.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String invoiceNumber;
    double unitPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    Provider providers;
    Date invoiceDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paid_status_id", referencedColumnName = "id")
    PaidStatus paidStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flatblock_id", referencedColumnName = "id")
    FlatBlock flatBlock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    MaterialAndExecution materialAndExecution;

    public Invoice(String invoiceNumber, double unitPrice, Provider providers, Date invoiceDate, PaidStatus paidStatus, FlatBlock flatBlock, MaterialAndExecution materialAndExecution) {
        this.invoiceNumber = invoiceNumber;
        this.unitPrice = unitPrice;
        this.providers = providers;
        this.invoiceDate = invoiceDate;
        this.paidStatus = paidStatus;
        this.flatBlock = flatBlock;
        this.materialAndExecution = materialAndExecution;
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

    public Provider getProviders() {
        return providers;
    }

    public void setProviders(Provider providers) {
        this.providers = providers;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public PaidStatus getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(PaidStatus status) {
        this.paidStatus = status;
    }

    public FlatBlock getFlatBlock() {
        return flatBlock;
    }

    public void setFlatBlock(FlatBlock flatBlock) {
        this.flatBlock = flatBlock;
    }

    public MaterialAndExecution getMaterial() {
        return materialAndExecution;
    }

    public void setMaterial(MaterialAndExecution materialAndExecution) {
        this.materialAndExecution = materialAndExecution;
    }
}
