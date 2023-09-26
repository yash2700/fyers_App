package com.fyers.fyers.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MultiOrderResponse {
    private String s;
    private int code;
    private String message;
    private List<MultiOrderResponseData> data;
}
