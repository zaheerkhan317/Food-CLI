package com.foodiecliapp.service;

import com.foodiecliapp.exceptions.CustomerExistsException;
import com.foodiecliapp.exceptions.CustomerNotFoundException;
import com.foodiecliapp.model.Customer;
import com.foodiecliapp.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    public CustomerRepository customerRepository;
    private Customer currentLoggedInCustomer;

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

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(String id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if(customerById.isEmpty()){
            throw new CustomerNotFoundException("Customer Not Found with id : "+id);
        }
        return customerById.get();
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getCustomerId());
        if(customerById.isEmpty()){
            throw new CustomerNotFoundException("Customer Not Found with id : "+customer.getCustomerId());
        }
        return this.customerRepository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(String id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if(customerById.isEmpty()){
            throw new CustomerNotFoundException("Customer Not Found with id : "+id);
        }
        this.customerRepository.deleteCustomer(customerById.get());
    }

    @Override
    public Customer validateCustomerLogin(String email, String password) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findByEmailAndPassword(email, password);
        if(customerById.isEmpty()){
            throw new CustomerNotFoundException("Invalid Email and Password!!!");
        }
        return customerById.get();
    }

    @Override
    public void setCurrentLoggedInCustomer(Customer customer) {
        this.currentLoggedInCustomer = customer;
    }

    @Override
    public Customer getCurrentLoggedInCustomer() {
        return this.currentLoggedInCustomer;
    }


}
