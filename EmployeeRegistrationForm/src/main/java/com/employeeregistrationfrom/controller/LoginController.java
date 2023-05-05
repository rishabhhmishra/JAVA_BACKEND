package com.employeeregistrationfrom.controller;

import com.employeeregistrationfrom.dao.entities.Employee;
import com.employeeregistrationfrom.sevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class LoginController {
private EmployeeService employeeService;
@Autowired
    public LoginController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("login")
    public String loginGet(ModelMap modelMap){
        Employee employee=new Employee();
        modelMap.addAttribute("employee",employee);
        return "login";
    }
    @PostMapping("login")
    public String loginPost(ModelMap modelMap,@ModelAttribute("employee")Employee employee){
        System.out.println("PPPPP"+employee);
        return "redirect:registration";
    }


    @GetMapping("register")
    public String registerGet(ModelMap modelMap){
        Employee employee=new Employee();
        modelMap.addAttribute("employee",employee);
        return "Registration";
    }
    @PostMapping("register")
    public String registerPost(ModelMap modelMap,@ModelAttribute("employee")Employee employee){
        System.out.println("rrrrrr"+employee);
         employeeService.registerEmployee(employee);
        return "redirect:registration";
    }


}
