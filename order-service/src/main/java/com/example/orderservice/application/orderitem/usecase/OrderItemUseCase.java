package com.example.orderservice.application.orderitem.usecase;
import com.example.orderservice.application.orderitem.entity.OrderItem;

import java.util.List;

public interface OrderItemUseCase {
    void saveAll(List<OrderItem> orderItems);
    List<OrderItem> getOrderItemByOrderId(Long orderId);
}
