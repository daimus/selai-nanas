package com.example.productservice.application.categories.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    private Long id;
    @NotEmpty(message = "Product category name is required")
    private String name;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;


    public ProductCategory(Long categoryId, String testCategory) {
    }
}
