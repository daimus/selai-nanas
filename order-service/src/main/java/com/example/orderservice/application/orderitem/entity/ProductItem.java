package com.example.orderservice.application.orderitem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {
    private Long id;
    private String name;
    private Integer price;
    private String description;
    private String images;
    private Integer quantity;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
