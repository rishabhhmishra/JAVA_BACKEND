package com.rxbh.dao;

public class Customer {
    private String name;
    private String contactNumber;
    private String address1;
    private String address2;
    private String state;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public Customer(String name, String contactNumber, String address1, String address2, String state) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.address1 = address1;
        this.address2 = address2;
        this.state = state;

    }

    public Customer(String[] data){
        System.out.println("constr");
        this.name=data[0];
        this.contactNumber =data[1];
       this.address1=data[2];
       this.address2=data[3];
       this.state=data[4];
    }
}
