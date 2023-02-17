package com.example.orderservice.application.orderitem.service;

import com.example.orderservice.application.order.repository.OrderRepository;
import com.example.orderservice.application.orderitem.entity.OrderItem;
import com.example.orderservice.application.orderitem.repository.OrderItemRepository;
import com.example.orderservice.application.orderitem.usecase.OrderItemUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService implements OrderItemUseCase {

    private final OrderItemRepository orderItemRepository;
    @Override
    public void saveAll(List<OrderItem> orderItems) {
        orderItemRepository.saveAll(orderItems);
    }

    @Override
    public List<OrderItem> getOrderItemByOrderId(Long orderId) {
        List<OrderItem> orderItems = orderItemRepository.getOrderItemByOrderId(orderId);
        return orderItems;
    }
}
