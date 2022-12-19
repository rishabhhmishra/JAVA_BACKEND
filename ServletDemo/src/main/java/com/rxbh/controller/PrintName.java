package com.rxbh.controller;

import com.rxbh.dao.Customer;
import com.rxbh.service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PrintName extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out=resp.getWriter();
//        out.print("Hello World!");
//        ServletConfig config=getServletConfig();
//        String name=config.getInitParameter("input");
//        out.print("name is: "+name);
           CustomerServiceImpl customerService =new CustomerServiceImpl();
//        out.print("Table Data : "+ customerService.showData());
        ArrayList<String> result=customerService.showData();
        out.print(" Table Data : ");
        for(String data:result)
            out.print("<br> "+data+ "<br>");

        //insertion
        String[] data=new String[2];
           String customerName=req.getParameter("name");
           String phoneNumber=req.getParameter("pno");

        Customer customer=null;
      //  customer.setName(customerName);
      //  customer.setPhoneNumber(phoneNumber);
           data[0]=customerName;
           data[1]=phoneNumber;
           int noOfRows=customerService.insertData(data);
           out.print("number of rows inserted : "+noOfRows);

    }
}
