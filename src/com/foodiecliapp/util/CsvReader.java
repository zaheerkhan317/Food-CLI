package com.foodiecliapp.util;

import com.foodiecliapp.model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public List<Customer> readCustomersFromCsv(){
        String customerCsvFilePath = "D:\\IntelliJ\\Food-CLI\\data\\customers.csv";
        List<Customer> customersList = new ArrayList<>();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(customerCsvFilePath))){
            String csvSplitBy = ",";
            br.readLine();
            while((line = br.readLine()) != null){
                String[] data = line.split(csvSplitBy);
                Customer customer = new Customer();
                customer.setId(data[0]);
                customer.setName(data[1]);
                customer.setEmail(data[2]);
                customer.setPassword(data[3]);
                customersList.add(customer);
            }
        }
        catch(IOException e){
            System.out.println("File not found in the path :"+customerCsvFilePath);
            System.exit(0);
            e.printStackTrace();
        }
        return customersList;
    }
}
