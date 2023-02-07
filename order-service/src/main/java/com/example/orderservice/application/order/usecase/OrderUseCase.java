package com.example.orderservice.application.order.usecase;
import com.example.orderservice.application.order.entity.Order;

import java.util.List;

public interface OrderUseCase {
    List<Order> getOrder();
    Order getOrderById(Long id);
    Order saveOrder(Order order);
    Order saveOrder(Long id, Order order);
    boolean deleteOrderById(Long id);
}
