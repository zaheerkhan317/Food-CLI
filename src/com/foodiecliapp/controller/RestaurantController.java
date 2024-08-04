package com.foodiecliapp.controller;

import com.foodiecliapp.service.RestaurantServiceImpl;

public class RestaurantController {

    private RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService){
        this.restaurantService = restaurantService;
    }

}
