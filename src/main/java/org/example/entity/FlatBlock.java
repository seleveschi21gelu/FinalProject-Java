package org.example.entity;

import javax.persistence.*;

@Entity
public class FlatBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "construction_type_id", referencedColumnName = "id")
    private ConstructionType constructionType;

    public FlatBlock(Integer id, String name, ConstructionType type) {
        this.id = id;
        this.name = name;
        this.constructionType = type;
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

    public ConstructionType getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(ConstructionType type) {
        this.constructionType = type;
    }
}
