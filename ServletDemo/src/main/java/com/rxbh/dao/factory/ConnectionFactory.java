package com.rxbh.dao.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
 static Connection connection=null;
  public static Connection getConnection(){
    Properties properties=new Properties();
    System.out.println("cf ctr");

    try {
        InputStream input=ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
        properties.load(input);
        System.out.println("1");
    } catch (IOException e) {
        e.printStackTrace();
    }
    String driverName=properties.getProperty("jdbc.driver");
    String url=properties.getProperty("jdbc.url");
    String username=properties.getProperty("jdbc.username");
    String password=properties.getProperty("jdbc.password");
    try {
        Class.forName(driverName);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    try {
        connection=DriverManager.getConnection(url,username,password);
        System.out.println("connection estb");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return connection;
}
}
