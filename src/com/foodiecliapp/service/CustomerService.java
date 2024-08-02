package com.foodiecliapp.service;

import com.foodiecliapp.exceptions.CustomerExistsException;
import com.foodiecliapp.model.Customer;

public interface CustomerService {
    public Customer save(Customer customer) throws CustomerExistsException;
}
