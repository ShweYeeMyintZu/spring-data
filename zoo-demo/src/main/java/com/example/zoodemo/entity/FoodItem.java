package com.example.zoodemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class FoodItem extends IdClass{

    private String name;
    private int quantity;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Supplier supplier;
    @ManyToMany(mappedBy = "foodItem")
    private List<Animal>animal=new ArrayList<>();


    public FoodItem() {
    }

    public FoodItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
