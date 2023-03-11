package com.example.productcustomerorder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerOrderProduct extends IdClass{
    @ManyToOne
private CustomerOrder customerOrder;
@ManyToOne
private Product product;

    public CustomerOrderProduct() {
    }
}
