package com.example.zoodemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends IdClass{
    private String type;
   @OneToMany(mappedBy = "categoryList",cascade = CascadeType.PERSIST)
    private List<Animal> animal=new ArrayList<>();

    public void addAnimal(Animal animal){
        animal.setCategoryList(this);
        this.animal.add(animal);
    }

    public Category() {
    }

    public Category(String type) {
        this.type = type;
    }
}
