package org.example.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class InvoiceDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String invoiceNumber;
    String materialAndExecution;
    String provider;
    LocalDate invoiceDate;
    Double unitPrice;
    Integer quantity;
    Double tva;
    String paidStatus;
    String flatblock;
    String  client;

    Double totalWithoutTva;
    Double totalWithTva;

    public InvoiceDTO() {
    }

    public InvoiceDTO(String invoiceNumber, String materialAndExecution, String provider, LocalDate invoiceDate, Double unitPrice, Integer quantity, Double tva, String paidStatus, String flatblock, String client) {
        this.invoiceNumber = invoiceNumber;
        this.materialAndExecution = materialAndExecution;
        this.provider = provider;
        this.invoiceDate = invoiceDate;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.tva = tva;
        this.paidStatus = paidStatus;
        this.flatblock = flatblock;
        this.client = client;
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

    public String getMaterialAndExecution() {
        return materialAndExecution;
    }

    public void setMaterialAndExecution(String materialAndExecution) {
        this.materialAndExecution = materialAndExecution;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    public String getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }

    public String getFlatblock() {
        return flatblock;
    }

    public void setFlatblock(String flatblock) {
        this.flatblock = flatblock;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Double getTotalWithoutTva() {
        return totalWithoutTva;
    }

    public void setTotalWithTvaDinamic(){
        this.totalWithTva = (unitPrice * quantity) * tva / 100 + (unitPrice * quantity);
    }
    public void setTotalWithoutTvaDinamic(){
        this.totalWithoutTva = unitPrice * quantity;
    }
    public void setTotalWithoutTva(Double totalWithoutTva) {
        this.totalWithoutTva = totalWithoutTva;
    }

    public Double getTotalWithTva() {
        return totalWithTva;
    }

    public void setTotalWithTva(Double totalWithTva) {
        this.totalWithTva = totalWithTva;
    }
}
