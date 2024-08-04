package com.foodiecliapp.controller;

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
}
