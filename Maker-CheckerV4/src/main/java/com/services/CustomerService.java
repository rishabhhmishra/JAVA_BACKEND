package com.services;

import com.model.entities.MasterTable;
import com.model.entities.TempTable;

import java.util.List;

public interface CustomerService {

    public void addCustomerToTemp(TempTable temp);

    public List<TempTable> getTempTable();

    public void deleteTemp(TempTable temp,String code);

    public void updateTempPost(TempTable tempTable);

    public TempTable getByCode(String code);

    public MasterTable getByCodeMaster(String code);

    public void addCustomerOnApprove(String code);

    public void onReject(String code);

    public List<MasterTable> getMastTable();

    public void makerModifiesMaster(MasterTable masterTable);

    public void makerDeletesMaster(String code);

}
