package com.javabrd.dao;

import com.javabrd.dao.factory.ConnectionFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public  int insertData(Customer customer) {

        try( Connection connection= ConnectionFactory.getConnection();){
            PreparedStatement preparedStatement=connection.prepareStatement("insert into Customer_Master_Rishabh " +
                    "(CUSTOMER_CODE,CUSTOMER_NAME," +
                    "ADDRESS1,ADDRESS2,PIN_CODE,EMAIL_ADDRESS,CONTACT_NUMBER," +
                    "PRIMARY_CONTACT_PERSON,RECORD_STATUS,FLAG,CREATE_DATE,CREATED_BY,MODIFIED_DATE," +
                    "MODIFIED_BY,AUTHORIZED_DATE,AUTHORIZED_BY) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
//            preparedStatement.setString(1,"sqsqs");
//            preparedStatement.setInt(2,23);
            preparedStatement.setString(1,customer.getCustomerCode());
            preparedStatement.setString(2,customer.getCustomerName());
            preparedStatement.setString(3,customer.getCustomerNameAddress1());
            preparedStatement.setString(4,customer.getCustomerNameAddress2());
            preparedStatement.setLong(5, customer.getCustomerPinCode());
            preparedStatement.setString(6,customer.getEmailAddress());
            preparedStatement.setLong(7,customer.getContactNumber());
            preparedStatement.setString(8,customer.getPrimaryContactPerson());
            preparedStatement.setString(9,customer.getRecordStatus());
            preparedStatement.setString(10,customer.getFlag());
            preparedStatement.setString(11,customer.getCreateDate());
            preparedStatement.setString(12,customer.getCreatedBy());
            preparedStatement.setString(13,customer.getModifiedDate());
            preparedStatement.setString(14,customer.getModifiedBy());
            preparedStatement.setString(15,customer.getAuthorizedDate());
            preparedStatement.setString(16,customer.getAuthorizedBy());
            int noOfRows= preparedStatement.executeUpdate();
            return noOfRows;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<String> getSystemParameter(){

        ArrayList<String> filePaths = new ArrayList<>();
        try( Connection connection = ConnectionFactory.getConnection();){


            PreparedStatement stmt = connection.prepareStatement("select * from SYSTEM_PARAMETER_RISHABH");
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                String fileName = res.getString(3);

                String path = res.getString(2);
                if(fileName.matches("[a-zA-Z0-9]{1,100}(.txt)") && res.getString(4).equals("R")){
                    filePaths.add(path+fileName);
                }
            }
            return filePaths;

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
