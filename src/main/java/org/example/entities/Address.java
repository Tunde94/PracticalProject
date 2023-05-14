package org.example.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Address {
    @EmbeddedId//pentru ca e vorba de mai multe coloane care vor forma cheia primara
    private AddressId id;

    private Integer squareMeter;

    @Enumerated(value = EnumType.STRING)
    private BuildingType buildingType;

    public Address() {
    }

    public Address(AddressId id, Integer squareMeter, BuildingType buildingType) {
        this.id = id;
        this.squareMeter = squareMeter;
        this.buildingType = buildingType;
    }

    public AddressId getId() {
        return id;
    }

    public void setId(AddressId id) {
        this.id = id;
    }

    public Integer getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(Integer squareMeter) {
        this.squareMeter = squareMeter;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }
}
