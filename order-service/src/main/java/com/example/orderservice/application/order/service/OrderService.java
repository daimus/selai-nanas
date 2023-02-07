package com.example.orderservice.application.order.service;

import com.example.orderservice.application.order.entity.Order;
import com.example.orderservice.application.order.repository.OrderRepository;
import com.example.orderservice.application.order.usecase.OrderUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderService implements OrderUseCase {
    private final OrderRepository orderRepository;
    @Override
    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order saveOrder(@Valid Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order saveOrder(Long id, @Valid Order order) {
        order.setId(id);
        return orderRepository.save(order);
    }

    @Override
    public boolean deleteOrderById(Long id) {
        orderRepository.deleteById(id);
        return true;
    }
}
