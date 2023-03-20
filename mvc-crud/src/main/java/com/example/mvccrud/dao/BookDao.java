package com.example.mvccrud.dao;

import com.example.mvccrud.Entity.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BookDao extends JpaRepository<Book,Integer> {
}
