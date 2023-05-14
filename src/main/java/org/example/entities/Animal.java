package org.example.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Animal {
    @Id
    private Integer id;
    private String name;
    private String type;
    private Person owner;

    public Animal() {
    }

    public Animal(Integer id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
