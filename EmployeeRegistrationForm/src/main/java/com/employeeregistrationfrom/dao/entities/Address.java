package com.employeeregistrationfrom.dao.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address_r_k")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer addressId;
    @Column(length = 50)
    private String buildingNo;
    @Column(length = 50)
    private String streetNo;
    @Column(length = 50)
    private String area;
    @Column(length = 50)
    private String city;
    @Column(length = 50)
    private String state;
    @Column(length = 50)
    private String pinCode;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    public Address() {
    }

    public Address(Integer addressId, String buildingNo, String streetNo, String area, String city,
                   String state, String pinCode, Employee employee) {
        this.addressId = addressId;
        this.buildingNo = buildingNo;
        this.streetNo = streetNo;
        this.area = area;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.employee = employee;
    }
    public Address( String buildingNo, String streetNo, String area, String city,
                   String state, String pinCode, Employee employee) {

        this.buildingNo = buildingNo;
        this.streetNo = streetNo;
        this.area = area;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.employee = employee;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
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
        Address address = (Address) o;
        return addressId.equals(address.addressId) && buildingNo.equals(address.buildingNo) && streetNo.equals(address.streetNo) && area.equals(address.area) && city.equals(address.city) && state.equals(address.state) && pinCode.equals(address.pinCode) && employee.equals(address.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, buildingNo, streetNo, area, city, state, pinCode, employee);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", buildingNo='" + buildingNo + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", employee=" + employee +
                '}';
    }
}
