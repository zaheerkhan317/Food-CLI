package com.foodiecliapp.service;

import com.foodiecliapp.exceptions.DishExistsException;
import com.foodiecliapp.exceptions.DishNotFoundException;
import com.foodiecliapp.model.Dish;
import com.foodiecliapp.repository.DishRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService{

    private DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository){
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getDishesList() {
        return this.dishRepository.getDishList();
    }

    @Override
    public Dish save(Dish dish) throws DishExistsException {
        Optional<Dish> dishById = this.dishRepository.getDishById(dish.getId());
        if(dishById.isPresent()){
            throw new DishExistsException("Dish already exists with this id : "+ dish.getId());
        }
        return this.dishRepository.saveDish(dish);
    }

    @Override
    public Dish getDishById(String id) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.getDishById(id);
        if(!dishById.isPresent()){
            throw new DishNotFoundException("Dish not found with id : "+id);
        }
        return dishById.get();
    }

    @Override
    public Dish update(Dish dish) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.getDishById(dish.getId());
        if(dishById.isEmpty()){
            throw new DishNotFoundException("Dish Not Found with id : "+dish.getId());
        }
        return this.dishRepository.updateDish(dish);
    }

    @Override
    public void delete(String id) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.getDishById(id);
        if(dishById.isEmpty()){
            throw new DishNotFoundException("Dish Not Found with id : "+id);
        }
        this.dishRepository.deleteDish(dishById.get());
    }
}
