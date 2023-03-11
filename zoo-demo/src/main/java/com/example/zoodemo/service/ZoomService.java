package com.example.zoodemo.service;

import com.example.zoodemo.dao.CageDao;
import com.example.zoodemo.dao.CategoryDao;
import com.example.zoodemo.dao.SupplierDao;
import com.example.zoodemo.entity.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ZoomService {
    private final CageDao cageDao;
    private final CategoryDao categoryDao;

    private final SupplierDao supplierDao;

    public ZoomService(CageDao cageDao, CategoryDao categoryDao, SupplierDao supplierDao) {
        this.cageDao = cageDao;
        this.categoryDao = categoryDao;
        this.supplierDao = supplierDao;
    }

    @Transactional
    public void createDb(){
        Cage c1=new Cage(1,"Tamwe");
        Cage c2=new Cage(2,"Botathaung");

        Animal a1=new Animal("Cat",23);
        Animal a2=new Animal("dog",45);

        c1.setAnimal(a1);
        c2.setAnimal(a2);

        cageDao.save(c1);
        cageDao.save(c2);

        Category ca1=new Category("Asian");
        Category ca2=new Category("Golden Retriver");

        ca1.addAnimal(a1);
        ca2.addAnimal(a2);

        categoryDao.save(ca1);
        categoryDao.save(ca2);

        Supplier s1=new Supplier("MOE MOE","0225555","Tamwe");
        Supplier s2=new Supplier("Htet Htet","25545","MONYar");

        FoodItem f1=new FoodItem("cake",5);
        FoodItem f2=new FoodItem("French Bread",3);

        s1.addFoodItem(f1);
        s2.addFoodItem(f2);

        supplierDao.save(s1);
        supplierDao.save(s2);

        a1.addFoodItem(f1);
        a2.addFoodItem(f2);




    }
}
