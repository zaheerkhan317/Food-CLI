package com.foodiecliapp.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {

    private String id;
    private Customer customer;
    private Restaurant restaurant;
    private double TotalPrice;
    private List<Dish> dishes;
    private Date orderDate;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(TotalPrice, order.TotalPrice) == 0 && Objects.equals(id, order.id) && Objects.equals(customer, order.customer) && Objects.equals(restaurant, order.restaurant) && Objects.equals(dishes, order.dishes) && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, restaurant, TotalPrice, dishes, orderDate);
    }

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", customer=" + customer + ", restaurant=" + restaurant + ", TotalPrice=" + TotalPrice + ", dishes=" + dishes + ", orderDate=" + orderDate + '}';
    }
}
