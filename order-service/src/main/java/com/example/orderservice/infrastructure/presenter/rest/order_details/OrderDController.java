package com.example.orderservice.infrastructure.presenter.rest.order_details;

import com.example.orderservice.application.order.entity.OrderD;
import com.example.orderservice.application.order.service.OrderDService;
import com.example.orderservice.infrastructure.presenter.rest.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detail")
@RequiredArgsConstructor
@Slf4j
public class OrderDController {
    private final OrderDService orderDService;
    @GetMapping
    public ResponseEntity<Object> getOrderD(){
        log.info("GET /details/{id} called");
        Response response = new Response();
        List<OrderD> orderD = orderDService.getOrderD();
        response.setData(orderD);
        return response.getResponse();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getOrderDById(@PathVariable Long id){
        log.info("GET /details/{id} called");
        Response response = new Response();
        OrderD orderD = orderDService.getOrderDById(id);
        response.setData(orderD);
        return response.getResponse();
    }
    @PostMapping
    public ResponseEntity<Object> saveDetails(@Valid @RequestBody OrderD orderD){
        log.info("GET /details/{id} called");
        Response response = new Response();
        orderD = orderDService.saveOrderD(orderD);
        response.setData(orderD);
        response.setHttpCode(201);
        return response.getResponse();
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Object> saveDetails(@PathVariable Long id, @RequestBody OrderD orderD){
        log.info("GET /details/{id} called");
        Response response = new Response();
        orderD = orderDService.saveOrderD(id, orderD);
        response.setData(orderD);
        return response.getResponse();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteDetailsById(@PathVariable Long id){
        log.info("GET /details/{id} called");
        Response response = new Response();
        orderDService.deleteOrderDById(id);
        response.setHttpCode(204);
        return response.getResponse();
    }
}
