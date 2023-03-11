package com.example.democonnectionjdbc.aspect;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnectioninvokationHandler implements InvocationHandler {
    private final Connection connection;

    public ConnectioninvokationHandler(Connection connection){
        this.connection=connection;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Connection trace: "+method.toGenericString());
        return method.invoke(connection,args);
    }
}
