package com.foodiecliapp.util;

import com.foodiecliapp.model.Customer;
import com.foodiecliapp.model.Dish;

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
                customer.setId(data[0])
                        .setName(data[1])
                        .setEmail(data[2])
                        .setPassword(data[3]);
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

    public List<Dish> readDishesFromCsv(){
        String DISHES_CSV_PATH = "D:\\IntelliJ\\Food-CLI\\data\\dishes.csv";
        String line;
        List<Dish> dishesList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(DISHES_CSV_PATH))){
            String cvsSplitBy = ",";
            br.readLine();
            while((line = br.readLine()) != null){
                String[] data = line.split(cvsSplitBy);
                Dish dish = new Dish();
                dish.setId(data[0])
                    .setName(data[1])
                    .setDescription(data[2])
                    .setPrice(Double.parseDouble(data[3]));
                dishesList.add(dish);
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Issues in reading csv file from path : "+ DISHES_CSV_PATH);
            System.exit(0);
        }
        return dishesList;
    }
}
