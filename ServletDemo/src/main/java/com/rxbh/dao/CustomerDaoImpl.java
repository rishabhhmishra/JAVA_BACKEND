package com.rxbh.dao;

import com.rxbh.dao.factory.ConnectionFactory;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {

Connection connection = null;
    @Override
    public int insertCustomer(Customer customer) {
        System.out.println("insert customer");
        Connection connection = ConnectionFactory.getConnection();
        try  {
            System.out.println("inside try");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into customer_rishabh values (?,?)");
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhoneNumber());


            int noOfRows = preparedStatement.executeUpdate();
            System.out.println("done insersion");
            return noOfRows;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public ArrayList<String> showData(Customer customer) {
        ArrayList<String> data=new ArrayList<>();
        try  {
            Connection connection = ConnectionFactory.getConnection();
             String info;
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer_rishabh");
          ResultSet resultSet= preparedStatement.executeQuery();
          while(resultSet.next()){
             String name=resultSet.getString(1);
             String phoneNumber=resultSet.getString(2);
              info=name.concat(" is name and contact number is ").concat(phoneNumber);
              data.add(info);

          }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
          return data;
    }
}
