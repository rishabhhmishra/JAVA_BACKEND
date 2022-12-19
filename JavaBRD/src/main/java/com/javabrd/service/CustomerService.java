package com.javabrd.service;

import com.javabrd.dao.Customer;

import java.util.ArrayList;

public interface CustomerService {
    ArrayList<Integer> insertData();
    ArrayList<String[]> readData(String path);
    ArrayList<String> validation(String[] data);


}
