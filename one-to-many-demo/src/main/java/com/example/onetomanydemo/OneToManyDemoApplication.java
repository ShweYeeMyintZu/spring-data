package com.example.onetomanydemo;

import com.example.onetomanydemo.service.AuthorService;
import com.example.onetomanydemo.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToManyDemoApplication implements CommandLineRunner {
    @Autowired
    private AuthorService authorService;

    public static void main(String[] args) {
        SpringApplication.run(OneToManyDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        authorService.saveAuthorWithThreeBooks();
        authorService.newThreeBooksWithoutAuthor();
//        System.out.println("__________________________________________________");
//        authorService.addNewBookWithExistingAuthor();
//        System.out.println("__________________________________________________");
//        authorService.removeFirstBookFromExistingAurthor();
//        System.out.println("__________________________________________________");
//        authorService.removelastBookFromExistingAurthor();
//        System.out.println("__________________________________________________");
        JPAUtil.checkData("select * from author");
        JPAUtil.checkData("select * from books");
        JPAUtil.checkData("select * from books_author");



    }
}
