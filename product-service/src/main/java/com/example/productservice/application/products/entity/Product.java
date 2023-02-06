package com.example.productservice.application.products.entity;

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
    private Integer quantity;
    private String description;
    private String image_url;
    private Integer sold;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

}