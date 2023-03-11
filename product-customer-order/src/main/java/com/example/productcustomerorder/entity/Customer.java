package com.example.productcustomerorder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer extends IdClass{

    private String name;

    private String email;

    private String phone;

    private String address;

    private String cityregion;
    private String ccnumber;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST)
    private List<CustomerOrder> customerOrder=new ArrayList<>();

    public void addcustomer(CustomerOrder customerOrder){
        customerOrder.setCustomer(this);
        this.customerOrder.add(customerOrder);

    }

    public Customer() {
    }

    public Customer(String name, String email, String phone, String address, String cityregion, String ccnumber) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cityregion = cityregion;
        this.ccnumber = ccnumber;
    }
}
