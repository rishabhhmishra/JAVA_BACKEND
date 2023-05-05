package com.employeeregistrationfrom.dao.impl;

import com.employeeregistrationfrom.dao.EmployeeDao;
import com.employeeregistrationfrom.dao.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {

        return sessionFactory.getCurrentSession();
    }

    @Override
    public void registerEmployee(Employee employee) {
       getSession().save(employee);
    }
}
