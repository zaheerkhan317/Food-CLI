package com.foodiecliapp.service;

import com.foodiecliapp.exceptions.DishNotFoundException;
import com.foodiecliapp.exceptions.RestaurantExistsException;
import com.foodiecliapp.exceptions.RestaurantNotFoundException;
import com.foodiecliapp.model.Dish;
import com.foodiecliapp.model.Restaurant;
import com.foodiecliapp.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getRestaurantList() {
        return null;
    }

    @Override
    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getId());
        if(restaurantById.isEmpty()){
            throw new RestaurantExistsException("Restaurant Already Exists wit id : "+restaurant.getId());
        }
        return this.restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
        return null;
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        return null;
    }

    @Override
    public void deleteRestaurant(String id) throws RestaurantNotFoundException {

    }

    @Override
    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException {
        return List.of();
    }
}
