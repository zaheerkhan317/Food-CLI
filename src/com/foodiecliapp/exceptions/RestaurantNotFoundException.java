package com.foodiecliapp.exceptions;

public class RestaurantNotFoundException extends Exception{
    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
