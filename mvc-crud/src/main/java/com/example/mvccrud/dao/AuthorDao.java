package com.example.mvccrud.dao;

import com.example.mvccrud.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AuthorDao extends JpaRepository<Author,Integer> {
}
