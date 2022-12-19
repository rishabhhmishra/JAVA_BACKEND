package com.rxbh.controller;

import com.rxbh.dao.Customer;
import com.rxbh.service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EmployeeApp extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out=resp.getWriter();
           CustomerServiceImpl customerService =new CustomerServiceImpl();

        String[] data=new String[5];
           String Name=req.getParameter("name");
           String contactNumber=req.getParameter("cno");
           String address1=req.getParameter("add1");
        String address2=req.getParameter("add2");
        String state=req.getParameter("state");



        Customer customer=null;

           data[0]=Name;
           data[1]=contactNumber;
           data[2]=address1+" "+address2+ " "+state;

           int noOfRows=customerService.insertData(data);
           out.print("<br>Your Entry Recorded Successfully <br >number of rows inserted : "+noOfRows);

    }
}
