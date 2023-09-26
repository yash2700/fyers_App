package com.fyers.fyers.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MultiOrderResponseData {
    private int statusCode;
    private OrderResponse body;
    private String statusDescription;

}
