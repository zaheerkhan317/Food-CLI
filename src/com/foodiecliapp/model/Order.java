package com.foodiecliapp.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {

    private String id;
    private Customer customer;
    private Restaurant restaurant;
    private double totalPrice;
    private List<Dish> dishList;
    private LocalDate orderDate;


    public String getId() {
        return id;
    }

    public Order setId(String id) {
        this.id = id;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Order setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public List<Dish> getDishList(){
        return dishList;
    }

    public Order setDishList(List<Dish> dishList){
        this.dishList = dishList;
        return this;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Order setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(totalPrice, order.totalPrice) == 0 && Objects.equals(id, order.id) && Objects.equals(customer, order.customer) && Objects.equals(restaurant, order.restaurant) && Objects.equals(dishList, order.dishList) && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, restaurant, totalPrice, dishList, orderDate);
    }

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", customer=" + customer + ", restaurant=" + restaurant + ", TotalPrice=" + totalPrice + ", dishes=" + dishList + ", orderDate=" + orderDate + '}';
    }
}
