package com.example.productcustomerorder;

import com.example.productcustomerorder.service.OrderService;
import com.example.productcustomerorder.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductCustomerOrderApplication implements CommandLineRunner {
@Autowired
private OrderService orderService;
    public static void main(String[] args) {
        SpringApplication.run(ProductCustomerOrderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderService.createDb();

        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from product");
        JPAUtil.checkData("select * from customer");
        JPAUtil.checkData("select * from customer_order");
        JPAUtil.checkData("select * from customer_order_product");


    }
}
