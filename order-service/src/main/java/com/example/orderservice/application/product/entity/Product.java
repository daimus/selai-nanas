package com.example.orderservice.application.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer stock;
    private String description;
    private String images;
    private Long categoryId;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
