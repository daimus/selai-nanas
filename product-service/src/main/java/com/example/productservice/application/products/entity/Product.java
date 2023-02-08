package com.example.productservice.application.products.entity;

import com.example.productservice.infrastructure.data.jpa.productCategory.ProductCategoryEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Price is required")
    private Integer price;
    @NotEmpty(message = "Stock is required")
    private Integer stock;
    private String description;
    @NotEmpty(message = "Product image is required")
    private String images;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategoryEntity category;
}