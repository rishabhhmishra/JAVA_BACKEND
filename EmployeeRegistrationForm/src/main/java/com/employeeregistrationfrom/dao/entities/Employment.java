package com.employeeregistrationfrom.dao.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employment_r_k")
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer employementId;
    @Column(length = 50)
    private String company;
    @Column(length = 50)
    private String designation;
    @Column(length = 50)
    private String startDate;
    @Column(length = 50)
    private String endDate;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    public Employment() {
    }

    public Employment(Integer employementId, String company, String designation, String startDate, String endDate, Employee employee) {
        this.employementId = employementId;
        this.company = company;
        this.designation = designation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public Employment(String company, String designation, String startDate, String endDate, Employee employee) {
        this.company = company;
        this.designation = designation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public Integer getEmployementId() {
        return employementId;
    }

    public void setEmployementId(Integer employementId) {
        this.employementId = employementId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employment that = (Employment) o;
        return employementId.equals(that.employementId) && company.equals(that.company) && designation.equals(that.designation) && startDate.equals(that.startDate) && endDate.equals(that.endDate) && employee.equals(that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employementId, company, designation, startDate, endDate, employee);
    }

    @Override
    public String toString() {
        return "Employment{" +
                "employementId=" + employementId +
                ", company='" + company + '\'' +
                ", designation='" + designation + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", employee=" + employee +
                '}';
    }
}
