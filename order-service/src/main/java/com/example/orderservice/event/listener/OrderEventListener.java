package com.example.orderservice.event.listener;

import com.example.orderservice.application.order.entity.Order;
import com.example.orderservice.application.order.type.OrderStatus;
import com.example.orderservice.application.order.usecase.OrderUseCase;
import com.example.orderservice.infrastructure.data.rest.xendit.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderEventListener {
    private final OrderUseCase orderUseCase;
    @Async
    @EventListener(condition = "@orderPredicate.orderUnpaid(#order.status)")
    void orderCreated(Order order) {
        log.info("order created UNPAID listener on listener");
    }

    @Async
    @EventListener(condition = "@orderPredicate.orderPaid(#order.status)")
    void orderPaid(Order order) {
        log.info("order created PAID listener on listener");
        order.setStatus(OrderStatus.PAID);
        orderUseCase.saveOrder(order);
    }

    @Async
    @EventListener(condition = "@orderPredicate.orderExpired(#order.status)")
    void orderExpired(Order order) {
        log.info("order created EXPIRED listener on listener");
        order.setStatus(OrderStatus.EXPIRED);
        orderUseCase.saveOrder(order);
    }

}
