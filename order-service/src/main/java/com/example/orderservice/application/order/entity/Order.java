package com.example.orderservice.application.order.entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Integer idProduct;
    private Integer idUser;
    @Enumerated(EnumType.STRING)
    private Order_Status status;
    private Integer total;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public enum Order_Status {
        UNPAID,
        PAID,
        CANCEL,
        DONE,
    }

}

