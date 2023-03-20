package com.example.jpaex.dao;

import com.example.jpaex.entity.CarManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarManufacturerDao extends JpaRepository<CarManufacturer,Integer> {
}
