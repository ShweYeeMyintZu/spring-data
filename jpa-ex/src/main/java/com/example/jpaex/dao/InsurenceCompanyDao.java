package com.example.jpaex.dao;

import com.example.jpaex.entity.InsuranceCompany;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurenceCompanyDao extends JpaRepository<InsuranceCompany,Integer> {
}
