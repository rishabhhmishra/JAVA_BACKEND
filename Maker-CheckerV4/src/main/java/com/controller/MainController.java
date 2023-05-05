package com.controller;

import com.model.entities.MasterTable;
import com.model.entities.TempTable;
import com.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    private CustomerService customerService;
    @Autowired
    public MainController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String start() {
        return "welcome";
    }


    @GetMapping(value="addcustomer")
    public String addCustomer(ModelMap modelMap){
        TempTable tempTable = new TempTable();
        modelMap.addAttribute("customer", tempTable);
        return "addcustomer";
    }

    @PostMapping(path = "addcustomer")
    public String addCustomerToTempTable(@ModelAttribute(name="customer") TempTable tempTable){
        customerService.addCustomerToTemp(tempTable);
        return "redirect:maker";
    }

    @GetMapping(path = "maker")
    public String getalltemp(ModelMap modelMap){
        List<TempTable> customerTempList = customerService.getTempTable();
        List<MasterTable> customerMasterList = customerService.getMastTable();

        modelMap.addAttribute("customerTempList" ,  customerTempList);
        List<MasterTable> newMasterTable = new ArrayList<>();

        for(MasterTable masterTable : customerMasterList){
            boolean flag = false;
            for (TempTable tempTable:customerTempList){
                if (tempTable.getCustomerCode().equals(masterTable.getCustomerCode()))
                {
                    flag = true;
                    break;
                }
            }
            if (!flag){newMasterTable.add(masterTable);}
        }
        modelMap.addAttribute("customerMasterList", newMasterTable);

        return "showmakers";
    }

    @GetMapping(path = "deleteCustomer")
    public String deleteTemp(@ModelAttribute(name = "customer")TempTable tempTable, @RequestParam(name="code")String code){
        customerService.deleteTemp(tempTable,code);
        return "redirect:maker";
    }

    @GetMapping(path = "update")
    public String updateTemp(ModelMap mp,@RequestParam(name = "code")String code){
        TempTable temp = customerService.getByCode(code);
        mp.addAttribute("customers",temp);
        return "updateTemp";
    }

    @PostMapping(path = "update")
    public String updateTempPost(@ModelAttribute(name = "customers")TempTable tempTable){
        customerService.updateTempPost(tempTable);
        return "redirect:maker";
    }

    @GetMapping(path = "checker")
    public String getAllMast(ModelMap mp){
        List<TempTable> list = customerService.getTempTable();
        mp.addAttribute("customerMastList",list);
        return "showcheckers";
    }

    @GetMapping(path = "approve")
    public String onApprove(@RequestParam(name = "code")String code){
        customerService.addCustomerOnApprove(code);
        return "redirect:checker";
    }

    @GetMapping(path = "reject")
    public String OnReject(@RequestParam(name = "code")String code){
        customerService.onReject(code);
        return "redirect:checker";
    }
    @GetMapping(path = "updateMast")
    public String updateMast(ModelMap mp,@RequestParam(name = "code")String code){
        MasterTable masterTable = customerService.getByCodeMaster(code);
        mp.addAttribute("customers", masterTable);
        return "updateMaster";
    }

    @PostMapping(path = "updateMasters")
    public String updateMast1(@ModelAttribute(name = "customers") MasterTable masterTable){
        System.out.println(masterTable);
        customerService.makerModifiesMaster(masterTable);
        return "redirect:maker";
    }

    @GetMapping(path = "deleteMast")
    public String makerDeleteMaster(@RequestParam(name = "code")String code){
        customerService.makerDeletesMaster(code);
        return "redirect:maker";
    }

    @ExceptionHandler(value=Exception.class )
    public String handle(HttpServlet req,Exception ex,ModelMap map){
        map.addAttribute("exceptionName",ex);
        return "exception";
    }



}
