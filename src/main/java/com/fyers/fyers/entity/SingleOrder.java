package com.fyers.fyers.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SingleOrder {
    private String symbol;
    private int qty;
    private int type;
    private int side;
    private String productType;
    private float limitPrice;
    private float stopPrice;
    private int disclosedQty;
    private String validity;
    private String offlineOrder;
    private float stopLoss;
    private float takeProfit;
}
