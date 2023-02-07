package com.example.orderservice.application.order.repository;

import com.example.orderservice.application.order.entity.OrderD;

import java.util.List;

public interface OrderDRepository {
    List<OrderD> findAll();
    OrderD findById(Long id);
    OrderD save(OrderD orderD);
    boolean deleteById(Long id);
}
