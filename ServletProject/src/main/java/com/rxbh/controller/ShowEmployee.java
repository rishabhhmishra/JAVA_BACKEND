package com.rxbh.controller;

import com.rxbh.service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ShowEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        CustomerServiceImpl customerService =new CustomerServiceImpl();
        ArrayList<String> result=customerService.showData();
        out.print(" Table Data : ");
        for(String data:result)
            out.print("<br> "+data+ "<br>");

    }
}
