package com.employeeregistrationfrom.sevice;

import com.employeeregistrationfrom.dao.EmployeeDao;
import com.employeeregistrationfrom.dao.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@EnableTransactionManagement 
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;
@Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void registerEmployee(Employee employee) {
        employeeDao.registerEmployee(employee);
    }
}
