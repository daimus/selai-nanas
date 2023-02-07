package com.example.orderservice.infrastructure.data.jpa.cart;

import com.example.orderservice.application.order.entity.Cart;
import com.example.orderservice.application.order.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CartRepositoryImpl implements CartRepository {
    private final JpaCartRepository jpaCartRepository;

    @Override
    public List<Cart> findAll() {
        List<CartEntity> cartEntities = (List<CartEntity>) jpaCartRepository.findAll();
        List<Cart> carts = new ArrayList<>();
        for (CartEntity cartEntity : cartEntities){
            Cart cart = new Cart();
            BeanUtils.copyProperties(cartEntity, cart);
            carts.add(cart);
        }
        return carts;
    }

    @Override
    public Cart findById(Long id) {
        Optional<CartEntity> cartEntities = jpaCartRepository.findById(id);
        if (cartEntities.isEmpty()){
            throw new NoSuchElementException();
        }
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartEntities.get(), cart);
        return cart;
    }

    @Override
    public Cart save(Cart cart) {
        CartEntity cartEntities = new CartEntity();
        BeanUtils.copyProperties(cart, cartEntities);
        cartEntities = jpaCartRepository.save(cartEntities);
        BeanUtils.copyProperties(cartEntities, cart);
        return cart;
    }

    @Override
    public boolean deleteById(Long id) {
        jpaCartRepository.deleteById(id);
        return true;
    }

}
