package com.example.orderservice.infrastructure.presenter.rest.xendit;

import com.example.orderservice.application.order.entity.Order;
import com.example.orderservice.application.order.type.OrderStatus;
import com.example.orderservice.application.order.usecase.OrderUseCase;
import com.example.orderservice.event.publisher.OrderEventPublisher;
import com.example.orderservice.infrastructure.presenter.rest.Response;
import com.example.orderservice.infrastructure.presenter.rest.xendit.dto.XenditRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class XenditController {
    private final OrderUseCase orderUseCase;
    @Autowired
    OrderEventPublisher orderEventPublisher;
    @PostMapping(path = "/payment/callback")
    public ResponseEntity<Object> callback(@RequestBody XenditRequest xenditRequest){
        log.info("POST /orders/payment/callback with body: {}", xenditRequest);
        if (xenditRequest.getStatus().equals("PAID")){
            Order order = orderUseCase.getOrderById(Long.valueOf(xenditRequest.getExternal_id()));
            order.setStatus(OrderStatus.PAID);
            orderEventPublisher.orderEvent(order);
        }
        Response response = new Response();
        return response.getResponse();
    }
}
