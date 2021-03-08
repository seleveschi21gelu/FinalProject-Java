package org.example.entity;

import javax.persistence.*;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "deliveryType_id", referencedColumnName = "id")
    DeliveryType deliveryType;
    @ManyToOne
    @JoinColumn(name = "providers_id", referencedColumnName = "id")
    Provider providers;
    boolean accepted;

    public Offer(DeliveryType deliveryType, Provider providers, boolean accepted) {
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

    public Provider getProviders() {
        return providers;
    }

    public void setProviders(Provider providers) {
        this.providers = providers;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
