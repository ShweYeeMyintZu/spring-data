package com.example.democonnectionjdbc.serive;

import com.example.democonnectionjdbc.dao.EmployeeDao;
import com.example.democonnectionjdbc.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployeeWithTransaction() {
        employeeDao.createEmployee(new Employee(7, "Thuzar", "Lin", "thuzar@gmail.com", 6000));
        employeeDao.createEmployee(new Employee(8, "Tawin", "Palaza", "tawin@gmail.com", 7000));
        employeeDao.createEmployee(new Employee(9, "Junction", "City", "city@gmail.com", 2000));
        employeeDao.createEmployee(new Employee(10, "Tamwe", "Ocean", "tamwe@gmail.com", 6500));
    }
}
