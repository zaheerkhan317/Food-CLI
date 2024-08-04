package com.foodiecliapp.util;

import com.foodiecliapp.controller.CustomerController;
import com.foodiecliapp.controller.DishController;
import com.foodiecliapp.controller.RestaurantController;
import com.foodiecliapp.repository.CustomerRepository;
import com.foodiecliapp.repository.DishRepository;
import com.foodiecliapp.repository.RestaurantRepository;
import com.foodiecliapp.service.CustomerServiceImpl;
import com.foodiecliapp.service.DishServiceImpl;
import com.foodiecliapp.service.RestaurantService;
import com.foodiecliapp.service.RestaurantServiceImpl;

public class Factory {

    public static CsvReader getCsvReader(){
        return new CsvReader();
    }

    public static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }

    public static CustomerServiceImpl getCustomerServiceImpl(){
        return new CustomerServiceImpl(getCustomerRepository());
    }

    public static CustomerController getCustomerController(){
        return new CustomerController(getCustomerServiceImpl());
    }

    public static DishRepository getDishRepository(){
        return new DishRepository();
    }

    public static DishServiceImpl getDishService(){
        return new DishServiceImpl(getDishRepository());
    }

    public static DishController getDishController(){
        return new DishController(getDishService());
    }

    public static RestaurantRepository getRestaurantRepository(){
        return new RestaurantRepository();
    }

    public static RestaurantServiceImpl getRestaurantService(){
        return new RestaurantServiceImpl(getRestaurantRepository());
    }

    public static RestaurantController getRestaurantController(){
        return new RestaurantController(getRestaurantService());
    }
}
