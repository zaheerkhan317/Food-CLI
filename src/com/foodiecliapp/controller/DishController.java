package com.foodiecliapp.controller;

import com.foodiecliapp.exceptions.DishExistsException;
import com.foodiecliapp.exceptions.DishNotFoundException;
import com.foodiecliapp.model.Dish;
import com.foodiecliapp.service.DishServiceImpl;

import java.util.List;

public class DishController {

    private DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService){
        this.dishService = dishService;
    }

    public List<Dish> getDishesList(){
        return this.dishService.getDishesList();
    }

    public Dish save(Dish dish) throws DishExistsException {
        return this.dishService.save(dish);
    }

    public Dish getDishById(String id) throws DishNotFoundException{
        return this.dishService.getDishById(id);
    }

    public Dish update(Dish dish) throws DishNotFoundException{
        return this.dishService.update(dish);
    }

    public void deleteDish(String id) throws DishNotFoundException{
        this.dishService.delete(id);
    }
}
