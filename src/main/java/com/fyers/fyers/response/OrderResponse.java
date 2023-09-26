package com.fyers.fyers.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderResponse {
    public String string;
    private int code;
    private String message;
    private String id;
}
