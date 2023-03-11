package com.example.productcustomerorder.dao;

import com.example.productcustomerorder.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
}
