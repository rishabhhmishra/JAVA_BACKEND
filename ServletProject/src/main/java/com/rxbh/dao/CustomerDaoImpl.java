package com.rxbh.dao;

import com.rxbh.dao.factory.ConnectionFactory;

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
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employeeDetails16804 (EmployeeId,Name,ContactNumber,Address) values (rishabh_employeeDetails16804.nextval,?,?,?)");
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getContactNumber());
            preparedStatement.setString(3,customer.getAddress1()+customer.getAddress2()+customer.getState());
             connection.commit();


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
       String[] data=new String[3];
       ArrayList<String> result=new ArrayList<>();


        try  {
            Connection connection = ConnectionFactory.getConnection();
            String info=null;
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employeeDetails16804");
          ResultSet resultSet= preparedStatement.executeQuery();
          while(resultSet.next()){
              int id=resultSet.getInt(1);
             String name=resultSet.getString(2);
             String contactNumber=resultSet.getString(3);
             String address=resultSet.getString(4);

             info=(" ID = "+id).concat(" Name : ").concat(name).concat(" Contact Number : ").concat(contactNumber).concat(" Address : ").concat(address);
           result.add(info);
          }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
          return result ;
    }
}
