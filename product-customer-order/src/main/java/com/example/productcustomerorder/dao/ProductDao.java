package com.example.productcustomerorder.dao;

import com.example.productcustomerorder.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
