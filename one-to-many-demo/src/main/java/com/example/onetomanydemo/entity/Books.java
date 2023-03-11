package com.example.onetomanydemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private double price;
    private String genre;
    @ManyToOne
    @JoinTable(
            name="books_author",
            joinColumns=
            @JoinColumn(name="books_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="author_id", referencedColumnName="id")
    )
    private Author author;
    public Books() {
    }

    public Books(String title, double price, String genre) {
        this.title = title;
        this.price = price;
        this.genre = genre;
    }
}
