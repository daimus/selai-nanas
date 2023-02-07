package com.example.orderservice.infrastructure.presenter.rest.cart;

import com.example.orderservice.application.order.entity.Cart;
import com.example.orderservice.application.order.service.CartService;
import com.example.orderservice.infrastructure.presenter.rest.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final CartService cartService;
    @GetMapping
    public ResponseEntity<Object> getCart(){
        log.info("GET /cart/{id} called");
        Response response = new Response();
        List<Cart> cart = cartService.getCart();
        response.setData(cart);
        return response.getResponse();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getCartById(@PathVariable Long id){
        log.info("GET /cart/{id} called");
        Response response = new Response();
        Cart cart = cartService.getCartById(id);
        response.setData(cart);
        return response.getResponse();
    }
    @PostMapping
    public ResponseEntity<Object> createCart(@Valid @RequestBody Cart cart){
        log.info("GET /cart/{id} called");
        Response response = new Response();
        cart = cartService.saveCart(cart);
        response.setData(cart);
        response.setHttpCode(201);
        return response.getResponse();
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Object> updateCart(@PathVariable Long id, @RequestBody Cart cart){
        log.info("GET /cart/{id} called");
        Response response = new Response();
        cart = cartService.saveCart(id, cart);
        response.setData(cart);
        return response.getResponse();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteCart(@PathVariable Long id){
        log.info("GET /cart/{id} called");
        Response response = new Response();
        cartService.deleteCartById(id);
        response.setHttpCode(204);
        return response.getResponse();
    }
}
