package com.example.onetoonedemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String streetNumber;
    private String city;
//    @OneToOne
//    @JoinColumn(name="customer_id_fk")
//    private Customer customer;
    @OneToOne(mappedBy = "address")
    private Customer customer;

    public Address() {
    }

    public Address(String street, String streetNumber, String city) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
    }
}
