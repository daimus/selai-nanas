package com.example.orderservice.application.cart.service;
import com.example.orderservice.application.cart.entity.Cart;
import com.example.orderservice.application.cart.repository.CartRepository;
import com.example.orderservice.application.cart.usecase.CartUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class CartService implements CartUseCase {
    private final CartRepository cartRepository;
    @Override
    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }
    @Override
    public List<Cart> getCarts(Long userId) {
        return cartRepository.findAll(userId);
    }
    @Override
    public Cart getCartById(Long id) {
        return cartRepository.findById(id);
    }
    @Override
    public Cart saveCart(@Valid Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart saveCart(Long id, @Valid Cart cartParam) {
        Cart cart = this.getCartById(id);
        cart.setQuantity(cartParam.getQuantity());
        return cartRepository.save(cart);
    }

    @Override
    public boolean deleteCartById(Long id) {
        cartRepository.deleteById(id);
        return true;
    }

    @Override
    public void deleteCartByUserId(Long userId) {
        cartRepository.deleteCartsByUserId(userId);
    }
}
