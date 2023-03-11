package com.example.productcustomerorder.service;

import com.example.productcustomerorder.dao.CategoryDao;
import com.example.productcustomerorder.dao.CustomerDao;
import com.example.productcustomerorder.dao.CustomerOrderDao;
import com.example.productcustomerorder.dao.ProductDao;
import com.example.productcustomerorder.entity.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {

    private final CategoryDao categoryDao;
   private final CustomerDao customerDao;

   private final ProductDao productDao;

   private final CustomerOrderDao customerOrderDao;

    public OrderService(CategoryDao categoryDao, CustomerDao customerDao, ProductDao productDao, CustomerOrderDao customerOrderDao) {
        this.categoryDao = categoryDao;
        this.customerDao = customerDao;
        this.productDao = productDao;
        this.customerOrderDao = customerOrderDao;
    }

    @Transactional
    public void createDb(){
        Product p1=new Product("L'oreal hydrating mask",10000,"Once A Week", LocalDate.now());
        Product p2=new Product("L'oreal Clay mask",9000,"Once A Week", LocalDate.now());
        Product p3=new Product("L'oreal LipStick",25000,"Riche", LocalDate.now());


        Category c1=new Category("Mask");
        Category c2=new Category("Makeup");

        c1.addProduct(p1);
        c1.addProduct(p2);
        c2.addProduct(p3);

        categoryDao.save(c1);
        categoryDao.save(c2);

        Customer cu=new Customer("Jenna Ortega","JennaOrtega@gmail.com","+1(551)295-7796","Coachella Valley","California,USA","1");

        CustomerOrder co1=new CustomerOrder(4000000,LocalDate.now(),4578);
        CustomerOrder co2=new CustomerOrder(8000000,LocalDate.now(),4578);

        cu.addcustomer(co1);
        cu.addcustomer(co2);

        customerDao.save(cu);

        CustomerOrderProduct cop1=new CustomerOrderProduct();
        p1.addCuOrPr(cop1);
        CustomerOrderProduct cop2=new CustomerOrderProduct();
        p2.addCuOrPr(cop2);
        CustomerOrderProduct cop3=new CustomerOrderProduct();
        p3.addCuOrPr(cop3);

        co1.addCuOrPr(cop1);
        co2.addCuOrPr(cop2);




    }
}
