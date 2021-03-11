package org.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String invoiceNumber;
    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    MaterialAndExecution materialAndExecution;


    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    Provider provider;
    Date invoiceDate;
    double unitPrice;
    String quantity;
    String TVA;
    double total;
    @ManyToOne
    @JoinColumn(name = "paid_status_id", referencedColumnName = "id")
    PaidStatus paidStatus;
    @ManyToOne
    @JoinColumn(name = "flatblock_id", referencedColumnName = "id")
    FlatBlock flatBlock;



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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider providers) {
        this.provider = providers;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTVA() {
        return TVA;
    }

    public void setTVA(String TVA) {
        this.TVA = TVA;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public MaterialAndExecution getMaterialAndExecution() {
        return materialAndExecution;
    }

    public void setMaterialAndExecution(MaterialAndExecution materialAndExecution) {
        this.materialAndExecution = materialAndExecution;
    }
}
