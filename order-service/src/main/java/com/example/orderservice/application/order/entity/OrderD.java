package com.example.orderservice.application.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderD {
    private Long id;
    private Integer idProduct;
    private Integer idOrder;
    private Integer quantity;
    private Integer price;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
}

