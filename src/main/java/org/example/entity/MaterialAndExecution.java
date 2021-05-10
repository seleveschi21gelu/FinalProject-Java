package org.example.entity;

import javax.persistence.*;

@Entity
public class MaterialAndExecution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @ManyToOne
    @JoinColumn(name = "deliveryType_id", referencedColumnName = "id")
    DeliveryType deliveryType;

//    public MaterialAndExecution(Integer id, String name, DeliveryType deliveryType) {
//        this.id = id;
//        this.name = name;
//        this.deliveryType = deliveryType;
//    }

    public MaterialAndExecution(String name, DeliveryType deliveryType) {
        this.name = name;
        this.deliveryType = deliveryType;
    }

    public MaterialAndExecution() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}
