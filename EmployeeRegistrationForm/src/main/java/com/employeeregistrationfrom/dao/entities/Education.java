package com.employeeregistrationfrom.dao.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="education_r_k")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer educationId;
    @Column(length = 50)
    private String degree;
    @Column(length = 50)
    private String institutionName;
    @Column(length = 50)
    private String passingYear;
    @Column(length = 50)
    private String percentage;
    @Column(length = 50)
    private String division;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    public Education() {
    }

    public Education(Integer educationId, String degree, String institutionName, String passingYear, String percentage, String division, Employee employee) {
        this.educationId = educationId;
        this.degree = degree;
        this.institutionName = institutionName;
        this.passingYear = passingYear;
        this.percentage = percentage;
        this.division = division;
        this.employee = employee;
    }

    public Education(String degree, String institutionName, String passingYear, String percentage, String division, Employee employee) {
        this.degree = degree;
        this.institutionName = institutionName;
        this.passingYear = passingYear;
        this.percentage = percentage;
        this.division = division;
        this.employee = employee;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(String passingYear) {
        this.passingYear = passingYear;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
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
        Education education = (Education) o;
        return educationId.equals(education.educationId) && degree.equals(education.degree) && institutionName.equals(education.institutionName) && passingYear.equals(education.passingYear) && percentage.equals(education.percentage) && division.equals(education.division) && employee.equals(education.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(educationId, degree, institutionName, passingYear, percentage, division, employee);
    }

    @Override
    public String toString() {
        return "Education{" +
                "educationId=" + educationId +
                ", degree='" + degree + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", passingYear='" + passingYear + '\'' +
                ", percentage='" + percentage + '\'' +
                ", division='" + division + '\'' +
                ", employee=" + employee +
                '}';
    }
}
