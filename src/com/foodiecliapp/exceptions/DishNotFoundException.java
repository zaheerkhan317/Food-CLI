package com.foodiecliapp.exceptions;

public class DishNotFoundException extends Exception{
    public DishNotFoundException(String message) {
        super(message);
    }
}
