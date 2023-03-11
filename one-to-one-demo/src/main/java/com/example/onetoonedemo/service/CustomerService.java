package com.example.onetoonedemo.service;

import com.example.onetoonedemo.dao.AddressDao;
import com.example.onetoonedemo.dao.CustomerDao;
import com.example.onetoonedemo.entity.Address;
import com.example.onetoonedemo.entity.Customer;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerDao customerDao;
    private final AddressDao addressDao;

    public CustomerService(CustomerDao customerDao,AddressDao addressDao){
        this.customerDao=customerDao;
        this.addressDao=addressDao;
    }

    public Customer findCustomerById(int id){
        return customerDao.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void createDb(){
        Customer customer1=new Customer("John Doe","55-555-55","john@gmail.com");
        Customer customer2=new Customer("Shwe","09-785956452","shwe@gmail.com");
        Address address1=new Address("Bridge Creek Road", "11211","NewYork");
        Address address2=new Address("DreamLand","No 56","Dokin");

     customer1.setAddress(address1);
     customer2.setAddress(address2);
//        address1.setCustomer(customer1);
//        address2.setCustomer(customer2);
        customerDao.save(customer1);
        customerDao.save(customer2);
        addressDao.save(address1);
        addressDao.save(address2);
    }
}
