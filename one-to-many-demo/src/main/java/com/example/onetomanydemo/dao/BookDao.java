package com.example.onetomanydemo.dao;

import com.example.onetomanydemo.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Books,Integer> {
}
