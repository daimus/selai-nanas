package com.example.orderservice.infrastructure.data.jpa.order;

import org.springframework.data.jpa.repository.JpaRepository;
public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {
}
