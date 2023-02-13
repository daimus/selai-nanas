package com.example.productservice.application.products.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Product name is required")
    private String name;
    @NotNull
    @Min(value = 1000)
    private Integer price;
    @NotNull
    @Min(value = 1)
    private Integer stock;
    private String description;
    @NotEmpty(message = "Product image is required")
    private String images;
    private Long category_id;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
}