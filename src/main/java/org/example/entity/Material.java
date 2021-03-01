package org.example.entity;

import org.example.entity.enums.DeliveryType;

import javax.persistence.*;

@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deliveryType_id", referencedColumnName = "id")
    DeliveryType type;

    public Material(Integer id, String name, DeliveryType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Material() {
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

    public DeliveryType getType() {
        return type;
    }

    public void setType(DeliveryType type) {
        this.type = type;
    }
}
