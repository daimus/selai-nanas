package com.example.orderservice.application.order.service;

import com.example.orderservice.application.order.entity.OrderD;
import com.example.orderservice.application.order.repository.OrderDRepository;
import com.example.orderservice.application.order.usecase.OrderDUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderDService implements OrderDUseCase {
    private final OrderDRepository orderDRepository;
    @Override
    public List<OrderD> getOrderD() {
        return orderDRepository.findAll();
    }

    @Override
    public OrderD getOrderDById(Long id) {
        return orderDRepository.findById(id);
    }

    @Override
    public OrderD saveOrderD(@Valid OrderD OrderD) {
        return orderDRepository.save(OrderD);
    }

    @Override
    public OrderD saveOrderD(Long id, @Valid OrderD OrderD) {
        OrderD.setId(id);
        return orderDRepository.save(OrderD);
    }

    @Override
    public boolean deleteOrderDById(Long id) {
        orderDRepository.deleteById(id);
        return true;
    }
}
