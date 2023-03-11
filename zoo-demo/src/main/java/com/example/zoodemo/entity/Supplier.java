package com.example.zoodemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Supplier extends IdClass {
    private String suppliername;
    private String contactno;

    private String address;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "supplier")
    private List<FoodItem>foodItems=new ArrayList<>();

    public void addFoodItem(FoodItem foodItem){
        foodItem.setSupplier(this);
        this.foodItems.add(foodItem);
    }


    public Supplier() {
    }

    public Supplier(String suppliername, String contactno, String address) {
        this.suppliername = suppliername;
        this.contactno = contactno;
        this.address = address;
    }
}
