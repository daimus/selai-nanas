package com.example.productservice.application.products.entity;

import com.example.productservice.infrastructure.data.jpa.productCategory.ProductCategoryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    private Long id;
    private String name;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    @ManyToOne
    private ProductCategoryEntity category;

}
