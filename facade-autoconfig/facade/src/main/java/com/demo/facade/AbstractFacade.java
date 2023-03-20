package com.demo.facade;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractFacade<T> {
    @PersistenceContext
    private EntityManager em;



    private Class<T> entityClass;



    public AbstractFacade(Class<T> entityClass){
        this.entityClass=entityClass;
    }
    @Transactional
    public void create(T t){
        em.persist(t);
    }
    @Transactional
    public void merge(T t){
        em.merge(t);
    }
    public T findById(Object id){
        return em.find(entityClass,id);
    }
}