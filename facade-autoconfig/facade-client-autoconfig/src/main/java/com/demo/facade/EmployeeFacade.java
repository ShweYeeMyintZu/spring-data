package com.demo.entity.facade;

import com.demo.entity.Employee;
import com.demo.facade.AbstractFacade;

public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {

    public EmployeeFacade(Employee entityClass) {
        super(Employee.class);
    }
}
