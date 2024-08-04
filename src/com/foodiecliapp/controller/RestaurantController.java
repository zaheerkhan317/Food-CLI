package com.foodiecliapp.controller;

import com.foodiecliapp.exceptions.RestaurantExistsException;
import com.foodiecliapp.exceptions.RestaurantNotFoundException;
import com.foodiecliapp.model.Restaurant;
import com.foodiecliapp.service.RestaurantService;
import com.foodiecliapp.service.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {

    private RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService){
        this.restaurantService = restaurantService;
    }

    public List<Restaurant> getRestaurantList(){
        return this.restaurantService.getRestaurantList();
    }

    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantExistsException {
        return this.restaurantService.save(restaurant);
    }

    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException{
        return this.restaurantService.getRestaurantById(id);
    }

    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException{
        return this.restaurantService.updateRestaurant(restaurant);
    }

    public void deleteRestaurant(String id) throws RestaurantNotFoundException{
        this.restaurantService.deleteRestaurant(id);
    }

}
