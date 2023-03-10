package com.example.manytomany.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity

@Getter
@Setter
public class Student extends IdClass{
    private String firstName;
    private String lastName;
    private String email;
//    @ManyToMany(cascade = CascadeType.PERSIST)
//    private List<Subject>subjects=new ArrayList<>();
//
//
//    public void addSubject(Subject subject){
//        this.subjects.add(subject);
//    }
@ManyToMany(mappedBy = "students")
private List<Subject>subjects=new ArrayList<>();

    public Student(){

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }
}
