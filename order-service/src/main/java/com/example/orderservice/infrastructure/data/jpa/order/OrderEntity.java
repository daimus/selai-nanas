package com.example.orderservice.infrastructure.data.jpa.order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer idProduct;
    private Integer idUser;

    @Enumerated(EnumType.STRING)
    private Order_Status status;
    private Integer total;
    @CreatedDate
    private Date created_at;
    @LastModifiedDate
    private Date updated_at;
    private Date deleted_at;

    public enum Order_Status {
        UNPAID,
        PAID,
        CANCEL,
        DONE,
    }

}
