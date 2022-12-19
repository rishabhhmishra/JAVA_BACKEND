package com.javabrd.dao;

import java.util.ArrayList;

public interface CustomerDao {
     int  insertData(Customer customer);


     ArrayList<String> getSystemParameter();
}
