package org.example.entities;

import jakarta.persistence.Embeddable;

@Embeddable//pentru ca AddressId este cheie primara compusa pentru Address
public class AddressId {

    private String streetName;
    private Integer nr;
    private String city;

    public AddressId(String streetName, Integer nr, String city) {
        this.streetName = streetName;
        this.nr = nr;
        this.city = city;
    }

    public AddressId() {
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
