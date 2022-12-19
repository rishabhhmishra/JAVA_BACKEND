package com.javabrd.controller;

import com.javabrd.dao.Customer;
import com.javabrd.dao.CustomerDaoImpl;
import com.javabrd.service.CustomerService;
import com.javabrd.service.CustomerServiceImpl;

import java.util.ArrayList;

public class Main {
   public static void main(String[] args) {

           ArrayList<Integer> rowsInserted = new CustomerServiceImpl().insertData();
           for (int i = 0; i < rowsInserted.size(); i++) {
               System.out.println(rowsInserted.get(i) + " Rows Inserted");
           }
       }
   }

