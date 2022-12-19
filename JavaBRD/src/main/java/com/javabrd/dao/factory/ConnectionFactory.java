package com.javabrd.dao.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
      private static Connection connection=null;
      public static Connection getConnection(){
            Properties properties=new Properties();
            try {
                  InputStream is = ConnectionFactory.class.getClassLoader()
                          .getResourceAsStream("db.properties");
                  properties.load(is);
            } catch(IOException e){
                  e.printStackTrace();

            }
            String driverName=properties.getProperty("jdbc.driver");
            String url=properties.getProperty("jdbc.url");
            String username=properties.getProperty("jdbc.username");
            String password=properties.getProperty("jdbc.password");

            try {
                  Class.forName(driverName);
            } catch (ClassNotFoundException e) {
                  e.printStackTrace();
            }
            try{
                  connection= DriverManager.getConnection(url,username,password);

            } catch (SQLException e) {

            }

            return connection;
      }

}
