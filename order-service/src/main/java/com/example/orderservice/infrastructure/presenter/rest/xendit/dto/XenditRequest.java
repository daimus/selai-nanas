package com.example.orderservice.infrastructure.presenter.rest.xendit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XenditRequest {
    private String id;
    private String external_id;
    private String user_id;
    private boolean is_high;
    private String status;
    private String merchant;
    private Integer amount;
    private Integer paid_amount;
    private String bank_code;
    private Date paid_at;
    private String payer_email;
    private String description;
    private Date created;
    private Date updated;
    private String currency;
    private String payment_channel;
    private String payment_destination;
}
