package com.example.orderservice.application.order.usecase;
import com.example.orderservice.application.order.entity.OrderD;

import java.util.List;

public interface OrderDUseCase {
    List<OrderD> getOrderD();
    OrderD getOrderDById(Long id);
    OrderD saveOrderD(OrderD OrderD);
    OrderD saveOrderD(Long id, OrderD OrderD);
    boolean deleteOrderDById(Long id);
}
