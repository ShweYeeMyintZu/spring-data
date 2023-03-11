package com.example.interoperability.service;

import com.example.interoperability.dao.EmployeeDao;
import com.example.interoperability.ds.Employee;
import jakarta.annotation.sql.DataSourceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    private JdbcTemplate jdbcTemplate;
    public EmployeeService(DataSource dataSource){
        jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);


    }
    public void createEmployeeWithJdbc(int id,String fistName,String lastName,String email,double salary) {
        jdbcTemplate.update("""
insert into employee(id,first_name,last_name,email,salary) values (?,?,?,?,?)
""",id,fistName,lastName,email,salary
        );
        }
        public void createEmployeeWithJpa(Employee employee){
            employeeDao.save(employee);
        }
        public Iterable<Employee>listEmployee(){
            return employeeDao.findAll();
        }
    public void deleteAllEmployee(){
        employeeDao.deleteAll();
    }

}
