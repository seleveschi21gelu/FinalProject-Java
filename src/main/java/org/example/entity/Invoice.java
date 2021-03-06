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
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    PaidStatus status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flatblock_id", referencedColumnName = "id")
    FlatBlock flatBlock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    Material material;

    public Invoice(String invoiceNumber, double unitPrice, Provider providers, Date invoiceDate, PaidStatus status, FlatBlock flatBlock, Material material) {
        this.invoiceNumber = invoiceNumber;
        this.unitPrice = unitPrice;
        this.providers = providers;
        this.invoiceDate = invoiceDate;
        this.status = status;
        this.flatBlock = flatBlock;
        this.material = material;
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

    public PaidStatus getStatus() {
        return status;
    }

    public void setStatus(PaidStatus status) {
        this.status = status;
    }

    public FlatBlock getFlatBlock() {
        return flatBlock;
    }

    public void setFlatBlock(FlatBlock flatBlock) {
        this.flatBlock = flatBlock;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
