package com.example.productcustomerorder.dao;

import com.example.productcustomerorder.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderDao extends JpaRepository<CustomerOrder,Integer> {
}
