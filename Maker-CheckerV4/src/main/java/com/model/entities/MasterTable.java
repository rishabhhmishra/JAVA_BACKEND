package com.model.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Master_rishabh")
public class MasterTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Customer_ID;
    @NotEmpty
    @Column(unique = true)
    private String customerCode;
    @NotEmpty
    private String customerName;
    @NotEmpty
    private String customerAddress1;
    private String customerAddress2;

    private int customerPinCode;
    @NotEmpty
    private String email;
    @NotEmpty
    private String contact;
    @NotEmpty
    private String primaryContactPerson;
    private String recordStatus;
    private LocalDate createDate;
    private String createdBy;
    private LocalDate modifiedDate;
    private String modifiedBy;
    private LocalDate authorizedDate;
    private String authorizedBy;

    public MasterTable(){

    }

    public MasterTable(String customerCode, String customerName, String customerAddress1, String customerAddress2, int customerPinCode, String email, String contact, String primaryContactPerson, String recordStatus, LocalDate createDate, String createdBy, LocalDate modifiedDate, String modifiedBy, LocalDate authorizedDate, String authorizedBy) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerAddress1 = customerAddress1;
        this.customerAddress2 = customerAddress2;
        this.customerPinCode = customerPinCode;
        this.email = email;
        this.contact = contact;
        this.primaryContactPerson = primaryContactPerson;
        this.recordStatus = recordStatus;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
        this.authorizedDate = authorizedDate;
        this.authorizedBy = authorizedBy;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress1() {
        return customerAddress1;
    }

    public void setCustomerAddress1(String customerAddress1) {
        this.customerAddress1 = customerAddress1;
    }

    public String getCustomerAddress2() {
        return customerAddress2;
    }

    public void setCustomerAddress2(String customerAddress2) {
        this.customerAddress2 = customerAddress2;
    }

    public int getCustomerPinCode() {
        return customerPinCode;
    }

    public void setCustomerPinCode(int customerPinCode) {
        this.customerPinCode = customerPinCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPrimaryContactPerson() {
        return primaryContactPerson;
    }

    public void setPrimaryContactPerson(String primaryContactPerson) {
        this.primaryContactPerson = primaryContactPerson;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(LocalDate authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterTable masterTable = (MasterTable) o;
        return Customer_ID == masterTable.Customer_ID && customerPinCode == masterTable.customerPinCode && Objects.equals(customerCode, masterTable.customerCode) && Objects.equals(customerName, masterTable.customerName) && Objects.equals(customerAddress1, masterTable.customerAddress1) && Objects.equals(customerAddress2, masterTable.customerAddress2) && Objects.equals(email, masterTable.email) && Objects.equals(contact, masterTable.contact) && Objects.equals(primaryContactPerson, masterTable.primaryContactPerson) && Objects.equals(recordStatus, masterTable.recordStatus) && Objects.equals(createDate, masterTable.createDate) && Objects.equals(createdBy, masterTable.createdBy) && Objects.equals(modifiedDate, masterTable.modifiedDate) && Objects.equals(modifiedBy, masterTable.modifiedBy) && Objects.equals(authorizedDate, masterTable.authorizedDate) && Objects.equals(authorizedBy, masterTable.authorizedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Customer_ID, customerCode, customerName, customerAddress1, customerAddress2, customerPinCode, email, contact, primaryContactPerson, recordStatus, createDate, createdBy, modifiedDate, modifiedBy, authorizedDate, authorizedBy);
    }

    @Override
    public String toString() {
        return "MasterTable{" +
                "Customer_ID=" + Customer_ID +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress1='" + customerAddress1 + '\'' +
                ", customerAddress2='" + customerAddress2 + '\'' +
                ", customerPinCode=" + customerPinCode +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", primaryContactPerson='" + primaryContactPerson + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                ", createDate=" + createDate +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", authorizedDate=" + authorizedDate +
                ", authorizedBy='" + authorizedBy + '\'' +
                '}';
    }
}