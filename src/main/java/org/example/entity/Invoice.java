package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

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
    LocalDate invoiceDate;
    double unitPrice;
    int quantity;
    double tva;
    @ManyToOne
    @JoinColumn(name = "paid_status_id", referencedColumnName = "id")
    PaidStatus paidStatus;
    @ManyToOne
    @JoinColumn(name = "flatblock_id", referencedColumnName = "id")
    FlatBlock flatBlock;

    public double getTotalWithTva(){
        return (unitPrice * quantity) * tva / 100 + (unitPrice * quantity);
    }

    public double getTotalWithoutTva(){
        return unitPrice * quantity;
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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider providers) {
        this.provider = providers;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
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

    public MaterialAndExecution getMaterialAndExecution() {
        return materialAndExecution;
    }

    public void setMaterialAndExecution(MaterialAndExecution materialAndExecution) {
        this.materialAndExecution = materialAndExecution;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
