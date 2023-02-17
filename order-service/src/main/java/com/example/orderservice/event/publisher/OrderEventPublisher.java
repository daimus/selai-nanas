package com.example.orderservice.event.publisher;

import com.example.orderservice.application.order.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventPublisher {
    private final ApplicationEventPublisher eventPublisher;
    public void orderEvent(Order order){
        eventPublisher.publishEvent(order);
    }
}
