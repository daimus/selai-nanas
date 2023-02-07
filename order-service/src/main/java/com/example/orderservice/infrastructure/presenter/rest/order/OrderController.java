package com.example.orderservice.infrastructure.presenter.rest.order;

import com.example.orderservice.application.order.entity.Order;
import com.example.orderservice.application.order.service.OrderService;
import com.example.orderservice.infrastructure.presenter.rest.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;
    @GetMapping
    public ResponseEntity<Object> getOrder(){
        log.info("GET /order/{id} called");
        Response response = new Response();
        List<Order> order = orderService.getOrder();
        response.setData(order);
        return response.getResponse();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable Long id){
        log.info("GET /order/{id} called");
        Response response = new Response();
        Order order = orderService.getOrderById(id);
        response.setData(order);
        return response.getResponse();
    }
    @PostMapping
    public ResponseEntity<Object> saveOrder(@Valid @RequestBody Order order){
        log.info("GET /order/{id} called");
        Response response = new Response();
        order = orderService.saveOrder(order);
        response.setData(order);
        response.setHttpCode(201);
        return response.getResponse();
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Object> saveOrder(@PathVariable Long id, @RequestBody Order order){
        log.info("GET /order/{id} called");
        Response response = new Response();
        order = orderService.saveOrder(id, order);
        response.setData(order);
        return response.getResponse();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteOrderById(@PathVariable Long id){
        log.info("GET /order/{id} called");
        Response response = new Response();
        orderService.deleteOrderById(id);
        response.setHttpCode(204);
        return response.getResponse();
    }
}
