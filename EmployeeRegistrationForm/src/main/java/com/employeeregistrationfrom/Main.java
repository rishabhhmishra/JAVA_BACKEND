package com.employeeregistrationfrom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        ApplicationContext ctx= new ClassPathXmlApplicationContext("hibernate-config.xml");
        System.out.println("**********************************");


    }
}