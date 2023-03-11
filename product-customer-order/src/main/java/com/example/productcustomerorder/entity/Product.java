package com.example.productcustomerorder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product extends IdClass{

    private String name;
    private int price;
    private String description;

    private LocalDate lastupdate;
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<CustomerOrderProduct>customerOrderProducts=new ArrayList<>();

    public void addCuOrPr(CustomerOrderProduct customerOrderProduct){
        customerOrderProduct.setProduct(this);
        this.customerOrderProducts.add(customerOrderProduct);
    }

    public Product() {
    }

    public Product(String name, int price, String description, LocalDate lastupdate) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.lastupdate = lastupdate;
    }
}
