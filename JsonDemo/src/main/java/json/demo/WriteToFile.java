package json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args)  {
        Employee employee=new Employee("Rishabh","16804","NSBT");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            objectMapper.writeValue( new File("src/details1.json"),employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
