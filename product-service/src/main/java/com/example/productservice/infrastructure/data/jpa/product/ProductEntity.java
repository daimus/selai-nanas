package com.example.productservice.infrastructure.data.jpa.product;
import com.example.productservice.infrastructure.data.jpa.productCategory.ProductCategoryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private Integer stock;
    private String description;
    private String images;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategoryEntity category;
}
