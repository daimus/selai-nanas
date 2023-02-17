package com.example.orderservice.application.orderitem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Integer price;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    public OrderItem(Long orderId, Long productId, Integer quantity, Integer price){
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

