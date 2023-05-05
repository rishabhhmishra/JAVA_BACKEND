package com.employeeregistrationfrom.dao.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee_r_k")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer employeeId;
    @Column(length = 50)
    private String employeeName;
    @Column(length = 50)
    private String fatherName;
    @Column(length = 50)
    private String dateOfBirth;
    @Column(length = 50)
    private String emailId;
    @Column(length = 15)
    private String mobileNumber;
   @OneToMany( mappedBy = "employee",cascade = CascadeType.ALL)
  private List<Address>addressList=new ArrayList<>();
    @OneToMany( mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Employment>employmentList=new ArrayList<>();
  @OneToMany( mappedBy = "employee",cascade = CascadeType.ALL)
  private List<Education>educationList=new ArrayList<>();
  private boolean disclaimer;

    public Employee() {
    }

    public Employee(String emailId, String mobileNumber) {
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
    }

    public Employee(Integer employeeId, String employeeName, String fatherName, String dateOfBirth, String emailId, String mobileNumber) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.fatherName = fatherName;
        this.dateOfBirth = dateOfBirth;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
    }

    public Employee(String employeeName, String fatherName, String dateOfBirth, String emailId, String mobileNumber) {
        this.employeeName = employeeName;
        this.fatherName = fatherName;
        this.dateOfBirth = dateOfBirth;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
    }

    public Employee(Integer employeeId, String employeeName, String fatherName, String dateOfBirth,
                    String emailId, String mobileNumber, List<Address> addressList,
                    List<Employment> employmentList, List<Education> educationList, boolean disclaimer) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.fatherName = fatherName;
        this.dateOfBirth = dateOfBirth;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.addressList = addressList;
        this.employmentList = employmentList;
        this.educationList = educationList;
        this.disclaimer = disclaimer;
    }

    public Employee(String employeeName, String fatherName, String dateOfBirth, String emailId, String mobileNumber,

                    List<Address> addressList, List<Employment> employmentList, List<Education> educationList, boolean disclaimer) {
        this.employeeName = employeeName;
        this.fatherName = fatherName;
        this.dateOfBirth = dateOfBirth;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.addressList = addressList;
        this.employmentList = employmentList;
        this.educationList = educationList;
        this.disclaimer = disclaimer;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Employment> getEmploymentList() {
        return employmentList;
    }

    public void setEmploymentList(List<Employment> employmentList) {
        this.employmentList = employmentList;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public boolean isDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(boolean disclaimer) {
        this.disclaimer = disclaimer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return disclaimer == employee.disclaimer && employeeId.equals(employee.employeeId) && employeeName.equals(employee.employeeName) && fatherName.equals(employee.fatherName) && dateOfBirth.equals(employee.dateOfBirth) && emailId.equals(employee.emailId) && mobileNumber.equals(employee.mobileNumber) && addressList.equals(employee.addressList) && employmentList.equals(employee.employmentList) && educationList.equals(employee.educationList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeName, fatherName, dateOfBirth, emailId, mobileNumber, addressList, employmentList, educationList, disclaimer);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", addressList=" + addressList +
                ", employmentList=" + employmentList +
                ", educationList=" + educationList +
                ", disclaimer=" + disclaimer +
                '}';
    }
}
