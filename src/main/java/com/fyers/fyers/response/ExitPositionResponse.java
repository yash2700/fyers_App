package com.fyers.fyers.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExitPositionResponse {
    private String s;
    private int code;
    private String  message;
}
