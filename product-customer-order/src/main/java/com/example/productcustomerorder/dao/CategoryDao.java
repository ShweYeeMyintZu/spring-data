package com.example.productcustomerorder.dao;

import com.example.productcustomerorder.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
