package com.example.interoperability.action;


import com.example.interoperability.ds.Employee;
import com.example.interoperability.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeAction {
    @Autowired
    private EmployeeService employeeService;

    public void deleteAllEmployee(){
        employeeService.deleteAllEmployee();
    }
    public Iterable<Employee>findAll(){
        return employeeService.listEmployee();
    }
    @Transactional
    public void createEmployee(){

        employeeService.createEmployeeWithJdbc(1,"John","Doe","doe@gmail.com",2000);
    employeeService.createEmployeeWithJdbc(2,"Thomas","Hardy","tomas@gmail.com",1000);
    employeeService.createEmployeeWithJpa(new Employee(3,"Richard","Lin","lin@gmail.com",8000));
    employeeService.createEmployeeWithJpa(new Employee(4,"Larvel","Lin","larvel@gmail.com",8000));

    throw new RuntimeException();
    }
}
