package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.entity.enums.Status;
import org.springframework.beans.factory.annotation.Value;

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
    Providers providers;
    Date invoiceDate;
    @Enumerated(EnumType.STRING)
    Status status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flatblock_id", referencedColumnName = "id")
    FlatBlock flatBlock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    Material material;

    public Invoice(String invoiceNumber, double unitPrice, Providers providers, Date invoiceDate, Status status, FlatBlock flatBlock, Material material) {
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
