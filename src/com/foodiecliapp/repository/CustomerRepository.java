package com.foodiecliapp.repository;

import com.foodiecliapp.model.Customer;
import com.foodiecliapp.util.CsvReader;
import com.foodiecliapp.util.Factory;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private List<Customer> customersList;

    public CustomerRepository(){
        this.customersList = Factory.getCustomerRepository().getAllCustomers();
    }

    public List<Customer> getAllCustomers(){
        return this.customersList;
    }

    public Customer save(Customer customer){
        this.customersList.add(customer);
        return customer;
    }

    public Optional<Customer> findCustomerById(String id){
        return this.customersList.stream().filter(customer -> customer.getCustomerId().equals(id)).findFirst();
    }
}
