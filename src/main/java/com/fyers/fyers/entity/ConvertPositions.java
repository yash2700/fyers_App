package com.fyers.fyers.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConvertPositions {
    private String symbol;
    private int positionSide;
    private int convertQty;
    private String convertFrom;
    private String convertTo;
}
