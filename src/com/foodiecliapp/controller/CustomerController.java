package com.foodiecliapp.controller;

import com.foodiecliapp.exceptions.CustomerExistsException;
import com.foodiecliapp.exceptions.CustomerNotFoundException;
import com.foodiecliapp.model.Customer;
import com.foodiecliapp.service.CustomerServiceImpl;

import java.util.List;

public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService){
        this.customerService = customerService;
    }

    public Customer save(Customer customer) throws CustomerExistsException{
        return this.customerService.save(customer);
    }

    public Customer validateCustomerLogin(String email, String password) throws CustomerNotFoundException{
        Customer customer = this.customerService.validateCustomerLogin(email, password);
        if(customer!=null){
            this.customerService.setCurrentLoggedInCustomer(customer);
        }
        return customer;
    }

    public Customer currentLoggedinCustomer(){
        return this.customerService.getCurrentLoggedInCustomer();
    }

    public Customer getCustomerById(String id) throws CustomerNotFoundException{
        return this.customerService.getCustomerById(id);
    }

    public List<Customer> getCustomersList(){
        return this.customerService.getAllCustomers();
    }

    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException{
        return this.customerService.updateCustomer(customer);
    }

    public void deleteCustomer(String id) throws CustomerNotFoundException{
        this.customerService.deleteCustomer(id);
    }


}
