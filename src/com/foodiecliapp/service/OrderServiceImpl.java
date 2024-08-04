package com.foodiecliapp.service;

import com.foodiecliapp.exceptions.OrderExistsException;
import com.foodiecliapp.exceptions.OrderNotFoundException;
import com.foodiecliapp.model.Order;
import com.foodiecliapp.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrdersList() {
        return this.orderRepository.getOrderList();
    }

    @Override
    public Order getOrderById(String id) throws OrderNotFoundException {
        Optional<Order> orderById = this.orderRepository.findOrderById(id);
        if(orderById.isEmpty()){
            throw new OrderNotFoundException("Order Not Found with id : "+id);
        }
        return orderById.get();
    }

    @Override
    public Order save(Order order) throws OrderExistsException {
        Optional<Order> orderById = this.orderRepository.findOrderById(order.getId());
        if(orderById.isPresent()){
            throw new OrderExistsException("Order Already Exists!!!");
        }
        return this.orderRepository.save(order);
    }
}
