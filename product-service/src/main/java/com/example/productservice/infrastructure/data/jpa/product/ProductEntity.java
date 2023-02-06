package com.example.productservice.infrastructure.data.jpa.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
