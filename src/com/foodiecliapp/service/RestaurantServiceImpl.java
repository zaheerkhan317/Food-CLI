package com.foodiecliapp.service;

import com.foodiecliapp.exceptions.DishNotFoundException;
import com.foodiecliapp.exceptions.RestaurantExistsException;
import com.foodiecliapp.exceptions.RestaurantNotFoundException;
import com.foodiecliapp.model.Dish;
import com.foodiecliapp.model.Restaurant;
import com.foodiecliapp.repository.RestaurantRepository;
import com.foodiecliapp.util.Factory;

import java.util.ArrayList;
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
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if(restaurantById.isEmpty()){
            throw new RestaurantNotFoundException("Restaurant Not Found with id : "+id);
        }
        return restaurantById.get();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getId());
        if(restaurantById.isEmpty()){
            throw new RestaurantNotFoundException("Restaurant Not Found with id : "+restaurant.getId());
        }
        return this.restaurantRepository.updateRestaurant(restaurant);
    }

    @Override
    public void deleteRestaurant(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if(restaurantById.isEmpty()){
            throw new RestaurantNotFoundException("Restaurant Not Found with id : "+id);
        }
        this.restaurantRepository.deleteRestaurant(restaurantById.get());
    }

    @Override
    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if(restaurantById.isEmpty()){
            throw new RestaurantNotFoundException("Restaurant Not Found with id : "+id);
        }
        List<Dish> dishList = new ArrayList<>();
        Restaurant restaurant = restaurantById.get();
        List<String> dishIds = restaurant.getMenu();
        DishService dishService = Factory.getDishService();
        for(String dishId : dishIds){
            Dish dish = dishService.getDishById(dishId);
            dishList.add(dish);
        }

        return dishList;

    }
}
