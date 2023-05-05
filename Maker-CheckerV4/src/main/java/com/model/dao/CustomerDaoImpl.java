package com.model.dao;

import com.model.entities.MasterTable;
import com.model.entities.TempTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository(value ="customerDao")
public class CustomerDaoImpl implements CustomerDao{

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCustomerToTemp(TempTable temp) {

        TempTable t1 = new TempTable(temp.getCustomerCode(),temp.getCustomerName(),temp.getCustomerAddress1(),temp.getCustomerAddress2(),temp.getCustomerPinCode(),temp.getEmail(),temp.getContact(),temp.getPrimaryContactPerson());
        t1.setRecordStatus("N");
        t1.setCreateDate(LocalDate.now());
        t1.setCreatedBy("Maker");
        t1.setModifiedBy(" ");
        getSession().persist(t1);
    }

    @Override
    public List<TempTable> getTempTable() {
        String query="select c from TempTable c";
        List<TempTable>temp = getSession().createQuery(query, TempTable.class).list();
        return temp;
    }

    @Override
    public void deleteTemp(TempTable temp,String code) {
        temp = getByCodeTemp(code);
        getSession().remove(temp);
    }

    @Override
    public void updateTempPost(TempTable tempTable) {
        TempTable customerTemp = getByCodeTemp(tempTable.getCustomerCode());
        customerTemp.setCustomerCode(tempTable.getCustomerCode());
        customerTemp.setCustomerName(tempTable.getCustomerName());
        customerTemp.setCustomerAddress1(tempTable.getCustomerAddress1());
        customerTemp.setCustomerAddress2(tempTable.getCustomerAddress2());
        customerTemp.setEmail(tempTable.getEmail());
        customerTemp.setContact(tempTable.getContact());
        customerTemp.setCustomerPinCode(tempTable.getCustomerPinCode());
        customerTemp.setModifiedDate(LocalDate.now());
        customerTemp.setModifiedBy("Maker");
        if(customerTemp.getRecordStatus().equals("NR")){
            customerTemp.setRecordStatus("M");
        }
        if(customerTemp.getRecordStatus().equals("MR")){
            customerTemp.setRecordStatus("N");
        }
        getSession().persist(customerTemp);
    }


    @Override
    public TempTable getByCodeTemp(String code){
        List<TempTable> tempList = getSession().createQuery("Select c from TempTable c" , TempTable.class).getResultList();
        TempTable cust = null;
        for (TempTable c : tempList){
            if(c.getCustomerCode().equals(code)){
                cust = c;
                break;
            }
        }
        return cust;
    }

    @Override
    public MasterTable getByCodeMaster(String code){
        List<MasterTable> masterTableList = getSession().createQuery("Select c from MasterTable c" , MasterTable.class).getResultList();
        MasterTable cust = null;
        for (MasterTable c : masterTableList){
            if(c.getCustomerCode().equals(code)){
                cust = c;
                break;
            }
        }
        return cust;
    }
    @Override
    public void addCustomerOnApprove(String code) {
        MasterTable mp = getByCodeMaster(code);
        TempTable tempTable = getByCodeTemp(code);
        MasterTable masterTable = new MasterTable();
        masterTable.setCustomerName(tempTable.getCustomerName());
        masterTable.setCustomerCode(tempTable.getCustomerCode());
        masterTable.setContact(tempTable.getContact());
        masterTable.setCustomerAddress1(tempTable.getCustomerAddress1());
        masterTable.setCustomerAddress2(tempTable.getCustomerAddress2());
        masterTable.setEmail(tempTable.getEmail());
        masterTable.setCustomerPinCode(tempTable.getCustomerPinCode());
        masterTable.setPrimaryContactPerson(tempTable.getPrimaryContactPerson());
        masterTable.setModifiedBy(tempTable.getModifiedBy());
        masterTable.setModifiedDate(tempTable.getModifiedDate());
        if(tempTable.getRecordStatus().equals("D")){
            getSession().remove(tempTable);
            getSession().remove(mp);
        }
        if(tempTable.getRecordStatus().equals("R")||tempTable.getRecordStatus().equals("MR")){
            System.out.println("Already Rejected");
        }

        else {
            masterTable.setRecordStatus("A");
            masterTable.setCreateDate(LocalDate.now());
            masterTable.setCreatedBy("Maker");
            masterTable.setAuthorizedBy("Checker");
            masterTable.setAuthorizedDate(LocalDate.now());
            getSession().remove(tempTable);
            getSession().persist(masterTable);
        }

    }

    @Override
    public void onReject(String code) {
        TempTable tempTable = getByCodeTemp(code);

        if(tempTable.getRecordStatus().equals("D")){
            tempTable.setRecordStatus("DR");
        }
        else {
            if(tempTable.getModifiedBy().equals("Maker")){
                tempTable.setRecordStatus("MR");
            }
            else{
                tempTable.setRecordStatus("NR");
            }
        }
        getSession().persist(tempTable);
    }

    @Override
    public List<MasterTable> getMasterTable() {
        List<MasterTable> list = getSession().createQuery("select p from MasterTable p", MasterTable.class).list();
        return list;
    }

    @Override
    public void makerModifiesMaster(MasterTable masterTable) {
        MasterTable mp = getByCodeMaster(masterTable.getCustomerCode());
        TempTable tempTable = new TempTable();
        tempTable.setCustomerCode(masterTable.getCustomerCode());
        tempTable.setCustomerName(masterTable.getCustomerName());
        tempTable.setCustomerAddress1(masterTable.getCustomerAddress1());
        tempTable.setCustomerAddress2(masterTable.getCustomerAddress2());
        tempTable.setCustomerPinCode(masterTable.getCustomerPinCode());
        tempTable.setEmail(masterTable.getEmail());
        tempTable.setContact(masterTable.getContact());
        tempTable.setPrimaryContactPerson(masterTable.getPrimaryContactPerson());
        tempTable.setRecordStatus("M");
        tempTable.setCreateDate(mp.getCreateDate());
        tempTable.setCreatedBy("Maker");
        tempTable.setCreatedBy(mp.getModifiedBy());
        tempTable.setModifiedDate(LocalDate.now());
        tempTable.setModifiedBy("Maker");
        tempTable.setAuthorizedDate(mp.getAuthorizedDate());
        tempTable.setAuthorizedBy(mp.getAuthorizedBy());
        getSession().persist(tempTable);
    }


    @Override
    public void makerDeletesMaster(String code) {
        MasterTable masterTable = getByCodeMaster(code);
        TempTable tempTable = new TempTable();
        tempTable.setCustomerCode(masterTable.getCustomerCode());
        tempTable.setCustomerName(masterTable.getCustomerName());
        tempTable.setCustomerAddress1(masterTable.getCustomerAddress1());
        tempTable.setCustomerAddress2(masterTable.getCustomerAddress2());
        tempTable.setCustomerPinCode(masterTable.getCustomerPinCode());
        tempTable.setEmail(masterTable.getEmail());
        tempTable.setContact(masterTable.getContact());
        tempTable.setPrimaryContactPerson(masterTable.getPrimaryContactPerson());
        tempTable.setRecordStatus("D");
        tempTable.setCreateDate(masterTable.getCreateDate());
        tempTable.setCreatedBy(masterTable.getCreatedBy());
        tempTable.setCreatedBy(masterTable.getModifiedBy());
        tempTable.setModifiedDate(LocalDate.now());
        tempTable.setModifiedBy(masterTable.getModifiedBy());
        tempTable.setAuthorizedDate(masterTable.getAuthorizedDate());
        tempTable.setAuthorizedBy(masterTable.getAuthorizedBy());
        getSession().persist(tempTable);
    }
}
