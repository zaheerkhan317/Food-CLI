package com.foodiecliapp.service;

import com.foodiecliapp.exceptions.DishExistsException;
import com.foodiecliapp.exceptions.DishNotFoundException;
import com.foodiecliapp.model.Dish;

import java.util.List;

public interface DishService {
    public List<Dish> getDishesList();
    public Dish save(Dish dish) throws DishExistsException;
    public Dish getDishById(String id) throws DishNotFoundException;
    public Dish update(Dish dish) throws DishNotFoundException;
    public void delete(String id) throws DishNotFoundException;
}
