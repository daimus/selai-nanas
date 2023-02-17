package com.example.orderservice.application.orderitem.repository;

import com.example.orderservice.application.orderitem.entity.OrderItem;

import java.util.List;

public interface OrderItemRepository {
    void saveAll(List<OrderItem> orderItems);
    List<OrderItem> getOrderItemByOrderId(Long orderId);
}
