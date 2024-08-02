package com.foodiecliapp.service;

import com.foodiecliapp.exceptions.CustomerExistsException;
import com.foodiecliapp.model.Customer;
import com.foodiecliapp.repository.CustomerRepository;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    public CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer save(Customer customer) throws CustomerExistsException {

        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getCustomerId());
        if(customerById.isPresent()){
            throw new CustomerExistsException("Customer already exists with this id: "+ customer.getCustomerId());
        }
        return this.customerRepository.save(customer);
    }
}
