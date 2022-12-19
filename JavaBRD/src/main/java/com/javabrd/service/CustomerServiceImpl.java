package com.javabrd.service;


import com.javabrd.dao.Customer;
import com.javabrd.dao.CustomerDao;
import com.javabrd.dao.CustomerDaoImpl;

import java.io.*;
import java.util.ArrayList;

import static com.javabrd.Validation.*;

public class CustomerServiceImpl implements CustomerService{


    @Override
    public ArrayList<Integer> insertData() {
        CustomerDao customerDao = new CustomerDaoImpl();
        ArrayList<String> filePaths = customerDao.getSystemParameter();
        ArrayList<Integer> insertions = new ArrayList<>();
        for (int i = 0 ; i < filePaths.size();i++ ) {
            int counter= 0;
            String filePath = filePaths.get(i);
            ArrayList<String[]> data =  readData(filePath);

            for(int j = 0; j < data.size();j++) {
                if (validation(data.get(j)).size() == 0){

                    Customer customerMaster = new Customer(data.get(j));
                 counter  += customerDao.insertData(customerMaster);

                }else{
                    System.out.println(validation(data.get(i)).toString());
                }
            }
            insertions.add(counter);
        }
        return insertions;
    }




    @Override
    public ArrayList<String[]> readData(String path) {
        ArrayList<String[]> data = new ArrayList<>();
        try{
            String line;
            System.out.println(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine())!=null){
                data.add(line.split("~"));
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        return data;
    }

    @Override
    public ArrayList<String> validation(String[] data) {
       ArrayList<String> errorMessages= new ArrayList<>();
        if(data.length < 12){
            errorMessages.add(" Insufficient Data ");
            return errorMessages;
        }
        else {
            String email = data[5];

            String recordStatus = data[8];

            Long pinCode = Long.parseLong(data[4]);

            String[] domainRecordStatus = {"N", "M", "D", "A", "R"};


            if (data[0].equals("") ||
                    data[1].equals("") ||
                    data[2].equals("") ||
                    data[3].equals("") ||
                    data[5].equals("") ||
                    data[6].equals("") ||
                    data[8].equals("") ||
                    data[9].equals("") ||
                    data[10].equals("") ||
                    data[11].equals("")) {
               errorMessages.add("Mandatory Fields Must Not be NUll");
                return errorMessages;
            }

            if (!dataLengthValidation(String.valueOf(pinCode), 6) && validateDataType(String.valueOf(pinCode) , "Integer")) {
                errorMessages.add("Pincode must be of 6 length");
            }

            if (!domainValidation(recordStatus, domainRecordStatus)) {
                errorMessages.add("Invalid Record Status");
            }

            if (!validateDataType(data[10], "Date")) {
                if (data.length >= 13) {
                    if (!validateDataType(data[12], "Date")) {
                        if (data.length >= 15) {
                            if (!validateDataType(data[14], "Date")) {
                                errorMessages.add("Invalid Date");
                            }
                        }
                        errorMessages.add("Invalid Date");
                    }
                }

                errorMessages.add("Invalid format of Date");
            }
            if (!validateEmail(email)) {
                errorMessages.add("Invalid Email");
            }
        }
        return errorMessages;
    }

}
