package com.example.orderservice.event.predicate;

import com.example.orderservice.application.order.entity.Order;
import com.example.orderservice.application.order.type.OrderStatus;
import com.example.orderservice.event.listener.OrderEventListener;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class OrderPredicate {
    public boolean orderUnpaid(OrderStatus status){
        return status.equals(OrderStatus.UNPAID);
    }
    public boolean orderPaid(OrderStatus status){
        return status.equals(OrderStatus.PAID);
    }
    public boolean orderExpired(OrderStatus status){
        return status.equals(OrderStatus.EXPIRED);
    }
}
