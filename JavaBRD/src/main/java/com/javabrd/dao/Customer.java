package com.javabrd.dao;

public class Customer {
    private int customerID;
    private String customerCode;
    private String customerName;
    private String customerNameAddress1;
    private String customerNameAddress2;
    private long  customerPinCode;
    private String emailAddress;
    private long contactNumber;
    private String primaryContactPerson;
    private String recordStatus;
    private String flag;
    private String createDate;
    private String createdBy;
    private String modifiedDate;
    private String modifiedBy;
    private String authorizedDate;
    private String authorizedBy ;
        public Customer(String[] data) {
            this.customerCode = data[0];
            this.customerName = data[1];
            this.customerNameAddress1 = data[2];
            this.customerNameAddress2 = data[3];
            this.emailAddress = data[5];
            this.primaryContactPerson = data[7];
            this.recordStatus = data[8];
            this.flag = data[9];
            this.createdBy = data[11];
            if(data.length > 13) {
                this.modifiedBy = data[13];
            }
            if(data.length > 15) {
                this.authorizedBy = data[15];
            }
            this.customerPinCode = Long.parseLong(data[4]);
            this.contactNumber =  Long.parseLong(data[6]);
            this.createDate = data[10];
            if(data.length > 12) {
                this.modifiedDate = data[12];
            }
            if(data.length > 14) {
                this.authorizedDate = data[14];
            }
        }


//    public int getCustomerID() {
//        return customerID;
//    }
//
//    public void setCustomerID(int customerID) {
//        this.customerID = customerID;
//    }

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

    public String getCustomerNameAddress1() {
        return customerNameAddress1;
    }

    public void setCustomerNameAddress1(String customerNameAddress1) {
        this.customerNameAddress1 = customerNameAddress1;
    }

    public String getCustomerNameAddress2() {
        return customerNameAddress2;
    }

    public void setCustomerNameAddress2(String customerNameAddress2) {
        this.customerNameAddress2 = customerNameAddress2;
    }

    public long getCustomerPinCode() {
        return customerPinCode;
    }

    public void setCustomerPinCode(long customerPinCode) {
        this.customerPinCode = customerPinCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(String authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }


}
