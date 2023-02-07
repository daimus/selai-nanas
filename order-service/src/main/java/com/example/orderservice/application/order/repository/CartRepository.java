package com.example.orderservice.application.order.repository;

import com.example.orderservice.application.order.entity.Cart;

import java.util.List;
public interface CartRepository {
    List<Cart> findAll();

    Cart findById(Long id);

    Cart save(Cart cart);
    boolean deleteById(Long id);
}
