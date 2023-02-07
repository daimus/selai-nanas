package com.example.orderservice.application.order.repository;

import com.example.orderservice.application.order.entity.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
    Order findById(Long id);
    Order save(Order order);
    boolean deleteById(Long id);
}
