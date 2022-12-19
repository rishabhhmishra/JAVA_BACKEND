package com.rxbh.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface CustomerDao {
    int insertCustomer(Customer customer);
    ArrayList<String> showData(Customer customer);


}
