package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    private String cnp;
    @Column(nullable = false)
    private String name;
    @Column(length = 40)
    private Integer yearOfBirth;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cnp='" + cnp + '\'' +
                ", name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", address=" + address +
                '}';
    }

    @ManyToOne//mai multe persoane poate locui la acelas adresa---creeaza coloane in plus nu tabele
    private Address address;

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Person() {
    }

    public Person(String cnp, String name, Integer yearOfBirth,Address address) {
        this.cnp = cnp;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
    }
}