package com.foodiecliapp.util;

import com.foodiecliapp.controller.CustomerController;
import com.foodiecliapp.repository.CustomerRepository;
import com.foodiecliapp.service.CustomerServiceImpl;

public class Factory {

    public static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }

    public static CustomerServiceImpl getCustomerServiceImpl(){
        return new CustomerServiceImpl(getCustomerRepository());
    }

    public static CustomerController getCustomerController(){
        return new CustomerController(getCustomerServiceImpl());
    }
}
