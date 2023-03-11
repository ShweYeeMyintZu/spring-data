package com.example.productcustomerorder.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class CustomerOrder extends IdClass{

    private int amount;

    private LocalDate date;

    private int confirmnum;
    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder",cascade = CascadeType.PERSIST)
    private List<CustomerOrderProduct> customerOrderProducts=new ArrayList<>();

    public void addCuOrPr(CustomerOrderProduct customerOrderProduct){
        customerOrderProduct.setCustomerOrder(this);
        this.customerOrderProducts.add(customerOrderProduct);
    }

    public CustomerOrder() {
    }

    public CustomerOrder(int amount, LocalDate date, int confirmnum) {

        this.amount = amount;
        this.date = date;
        this.confirmnum = confirmnum;
    }
}
