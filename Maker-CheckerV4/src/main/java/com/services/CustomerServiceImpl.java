package com.services;

import com.model.entities.MasterTable;
import com.model.entities.TempTable;
import com.model.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public void addCustomerToTemp(TempTable temp) {
        customerDao.addCustomerToTemp(temp);
    }

    @Override
    public List<TempTable> getTempTable() {
        return customerDao.getTempTable();
    }

    @Override
    public void deleteTemp(TempTable temp, String code) {
        customerDao.deleteTemp(temp,code);
    }

    @Override
    public void updateTempPost(TempTable tempTable) {
        customerDao.updateTempPost(tempTable);
    }

    @Override
    public TempTable getByCode(String code) {
        return customerDao.getByCodeTemp(code);
    }

    @Override
    public MasterTable getByCodeMaster(String code) {
        return customerDao.getByCodeMaster(code);
    }

    @Override
    public void addCustomerOnApprove(String code) {
        customerDao.addCustomerOnApprove(code);
    }

    @Override
    public void onReject(String code) {
        customerDao.onReject(code);
    }

    @Override
    public List<MasterTable> getMastTable() {
        return customerDao.getMasterTable();
    }

    @Override
    public void makerModifiesMaster(MasterTable masterTable) {
        customerDao.makerModifiesMaster(masterTable);
    }

    @Override
    public void makerDeletesMaster(String code) {
        customerDao.makerDeletesMaster(code);
    }


}
