package com.fyers.fyers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoldingsDto {
    private String symbol;
    private String holdingType;
    private int quantity;
    private int remainingQuantity;
    private float pl;
    private float costPrice;
    private float marketVal;
    private float ltp;
    private int id;
    private String fyToken;
    private int exchange;
    private int segment;
    private String isin;
    private int qty_t1;
    private  int remainingPledgeQuantity;
    private int collateralQuantity;

}
