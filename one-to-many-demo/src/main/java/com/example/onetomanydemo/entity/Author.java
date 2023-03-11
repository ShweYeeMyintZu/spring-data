package com.example.onetomanydemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @OneToMany(cascade = CascadeType.PERSIST,orphanRemoval = true,mappedBy = "author")
    private List<Books> books=new LinkedList<>();

    public void removeBook(Books book){

        book.setAuthor(null);
        books.remove(book);
    }


    public void addBook(Books books){
        books.setAuthor(this);
        this.books.add(books);
    }

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }
}
