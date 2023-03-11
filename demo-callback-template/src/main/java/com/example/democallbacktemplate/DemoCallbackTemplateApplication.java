package com.example.democallbacktemplate;

import com.example.democallbacktemplate.ds.Employee;
import com.example.democallbacktemplate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class DemoCallbackTemplateApplication implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;


    public static void main(String[] args) {
        SpringApplication.run(DemoCallbackTemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.listAllEmployee().forEach(System.out::println);
        System.out.println("Average Salary::  $"+employeeService.avgRollCallBackHandler());
        System.out.println("Average Salary::  $"+employeeService.avgResultSetExtractor());
        System.out.println("Find with email:: "+employeeService.findEmployeeByEmail("dave@gmail.com"));
        System.out.println();
        employeeService.createEmployee(new Employee(7,"Shwe Yee","Myint Zu","shwe@gmail.com",5000002));
        employeeService.listAllEmployee().forEach(System.out::println);
        System.out.println("Avg Native ::"+employeeService.avgNativeWay());
        System.out.println("Avg Modern Way ::"+employeeService.avgModernWay());
    }
}
