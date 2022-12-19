package com.rxbh.service;

import com.rxbh.dao.Customer;
import com.rxbh.dao.CustomerDao;
import com.rxbh.dao.CustomerDaoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerServiceImpl implements CustomerService{
    CustomerDao customerDao=new CustomerDaoImpl();
    Customer customer;
    @Override
    public int insertData(String[] data) {
        System.out.println("insert data");
         customer=new Customer(data);
        int noOfRows=customerDao.insertCustomer(customer);
        return noOfRows;
    }

    @Override
    public ArrayList<String> showData() {
        System.out.println("show customer");
       ArrayList<String> data=customerDao.showData(customer);

        return data;
    }
}
