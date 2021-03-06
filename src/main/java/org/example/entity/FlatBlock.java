package org.example.entity;

import javax.persistence.*;

@Entity
public class FlatBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private ConstructionType type;

    public FlatBlock(Integer id, String name, ConstructionType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public FlatBlock() {
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

    public ConstructionType getType() {
        return type;
    }

    public void setType(ConstructionType type) {
        this.type = type;
    }
}
