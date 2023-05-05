package json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Employee employee=new Employee("Rishabh","16804","NSBT");
        try {
            ObjectMapper objectMapper=new ObjectMapper();
            objectMapper.writeValue(new File("src/emp.json"),employee);

            String jsonStr="{\"name\":\"Rishabh\",\"employeeId\":\"16804\",\"department\":\"NSBT\"}";

            Employee emp=objectMapper.readValue(jsonStr , Employee.class);
            System.out.println(emp.getEmployeeId());
            System.out.println(emp.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}