package com.example.orderservice.application.order.usecase;
import com.example.orderservice.application.order.entity.Cart;

import java.util.List;

public interface CartUseCase {
    List<Cart> getCart();

    Cart getCartById(Long id);

    Cart saveCart(Cart cart);
    Cart saveCart(Long id, Cart cart);
    boolean deleteCartById(Long id);
}
