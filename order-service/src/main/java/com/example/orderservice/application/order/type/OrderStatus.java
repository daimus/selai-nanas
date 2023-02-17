package com.example.orderservice.application.order.type;

import lombok.Data;

public enum OrderStatus {
    UNPAID,
    PAID,
    CANCEL,
    EXPIRED,
    DONE
}
