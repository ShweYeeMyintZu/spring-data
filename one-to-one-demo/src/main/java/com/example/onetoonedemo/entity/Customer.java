package com.example.onetoonedemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String email;
//    @JoinColumn(name="address_id_jk")
//    @OneToOne
//    private Address address;
    @JoinColumn(name = "add_id_fk")
    @OneToOne
    private Address address;

    public Customer() {
    }

    public Customer(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
