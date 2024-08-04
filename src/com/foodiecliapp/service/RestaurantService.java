package com.foodiecliapp.service;

import com.foodiecliapp.exceptions.DishNotFoundException;
import com.foodiecliapp.exceptions.RestaurantExistsException;
import com.foodiecliapp.exceptions.RestaurantNotFoundException;
import com.foodiecliapp.model.Dish;
import com.foodiecliapp.model.Restaurant;

import java.util.List;

public interface RestaurantService{

    public List<Restaurant> getRestaurantList();

    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException;

    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException;

    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;

    public void deleteRestaurant(String id) throws RestaurantNotFoundException;

    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException;

}
