package com.demo.entity.facade;

import com.demo.entity.Employee;

public interface EmployeeFacadeLocal {
    void create(Employee employee);
    void merge(Employee employee);

    Employee findById(Object id);

}
