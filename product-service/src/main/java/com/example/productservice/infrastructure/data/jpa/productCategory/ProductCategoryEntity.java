package com.example.productservice.infrastructure.data.jpa.productCategory;

import com.example.productservice.application.products.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_category")
public class ProductCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
