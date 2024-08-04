package com.foodiecliapp.repository;

import com.foodiecliapp.model.Restaurant;
import com.foodiecliapp.util.Factory;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class RestaurantRepository {

    private List<Restaurant> restaurantList;

    public RestaurantRepository(){
        this.restaurantList = Factory.getCsvReader().readRestaurantsFromCsv();
    }

    public List<Restaurant> getRestaurantList(){
        return this.restaurantList;
    }

    public Restaurant save(Restaurant restaurant){
        this.restaurantList.add(restaurant);
        return restaurant;
    }

    public Optional<Restaurant> findRestaurantById(String id){
        return this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(id)).findFirst();
    }

    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated){
        Optional<Restaurant> restaurantUpdate = this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(restaurantToBeUpdated.getId()))
                .findFirst()
                .map(restaurant -> {
                    restaurant.setName(restaurantToBeUpdated.getName())
                            .setAddress(restaurantToBeUpdated.getAddress())
                            .setMenu(restaurantToBeUpdated.getMenu());
                    return restaurant;
                });
        return restaurantUpdate.orElse(null);
    }

    public void deleteRestaurant(Restaurant restaurant){
        this.restaurantList.remove(restaurant);
    }

}
