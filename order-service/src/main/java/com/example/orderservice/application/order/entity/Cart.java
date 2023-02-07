package com.example.orderservice.application.order.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long idProduct;
    private long idUser;
    private Integer quantity;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

}