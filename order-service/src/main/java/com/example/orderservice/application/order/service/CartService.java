package com.example.orderservice.application.order.service;
import com.example.orderservice.application.order.entity.Cart;
import com.example.orderservice.application.order.repository.CartRepository;
import com.example.orderservice.application.order.usecase.CartUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class CartService implements CartUseCase {
    private final CartRepository cartRepository;
    @Override
    public List<Cart> getCart() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartById(Long id) {
        return null;
    }


    @Override
    public Cart saveCart(@Valid Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart saveCart(Long id, @Valid Cart cart) {
        cart.setId(id);
        return cartRepository.save(cart);
    }

    @Override
    public boolean deleteCartById(Long id) {
        cartRepository.deleteById(id);
        return true;
    }
}
