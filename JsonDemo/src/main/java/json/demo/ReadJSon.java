package json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ReadJSon {
    public static void main(String[] args) {
        String jsonStr="{\"name\":\"Rishabh\",\"employeeId\":\"16804\",\"department\":\"NSBT\"}";
        ObjectMapper objectMapper=new ObjectMapper();


        {
            try {
                Employee   emp = objectMapper.readValue(jsonStr, Employee.class);
                System.out.println(emp.getEmployeeId());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
