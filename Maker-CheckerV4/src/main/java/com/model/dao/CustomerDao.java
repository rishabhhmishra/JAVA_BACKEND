package com.model.dao;

import com.model.entities.MasterTable;
import com.model.entities.TempTable;

import java.util.List;


public interface CustomerDao {

    public void addCustomerToTemp(TempTable temp);

    public List<TempTable> getTempTable();

    public void deleteTemp(TempTable temp,String code);

    public void updateTempPost(TempTable tempTable);

    public TempTable getByCodeTemp(String code);

    public MasterTable getByCodeMaster(String code);

    public void addCustomerOnApprove(String code);

    public void onReject(String code);

    public List<MasterTable> getMasterTable();

    public void makerModifiesMaster(MasterTable masterTable);

    public void makerDeletesMaster(String code);


}
