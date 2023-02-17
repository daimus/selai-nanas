package com.example.orderservice.infrastructure.data.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse {
    private String meta;
    private String data;
    private String page;
}
