package org.example.entity;

import org.example.entity.enums.DeliveryType;

import javax.persistence.*;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    DeliveryType deliveryType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "providers_id", referencedColumnName = "id")
    Providers providers;
    boolean accepted;

    public Offer(DeliveryType deliveryType, Providers providers, boolean accepted) {
        this.deliveryType = deliveryType;
        this.providers = providers;
        this.accepted = accepted;
    }

    public Offer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Providers getProviders() {
        return providers;
    }

    public void setProviders(Providers providers) {
        this.providers = providers;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}