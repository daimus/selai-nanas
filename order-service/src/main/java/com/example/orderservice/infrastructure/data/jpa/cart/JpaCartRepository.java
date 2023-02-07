package com.example.orderservice.infrastructure.data.jpa.cart;

import org.springframework.data.jpa.repository.JpaRepository;
public interface JpaCartRepository extends JpaRepository<CartEntity, Long> {
}
