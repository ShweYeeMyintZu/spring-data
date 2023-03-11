package com.example.zoodemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Animal extends IdClass{
    private String type;
    private int totalno;
    @OneToOne(mappedBy = "animal",cascade = CascadeType.PERSIST)
    private Cage cage;
    @ManyToOne
    private Category categoryList;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<FoodItem>foodItem=new ArrayList<>();

    public void addFoodItem(FoodItem foodItem){
        foodItem.getAnimal().add(this);
        this.foodItem.add(foodItem);
    }



    public Animal() {
    }

    public Animal(String type, int totalno) {
        this.type = type;
        this.totalno = totalno;
    }
}
