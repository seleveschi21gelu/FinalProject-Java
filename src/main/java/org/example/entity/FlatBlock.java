package org.example.entity;

import org.example.entity.enums.Type;

import javax.persistence.*;
import java.util.List;

@Entity
public class FlatBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;

    public FlatBlock(Integer id, String name, Type type) {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
