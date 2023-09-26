package com.fyers.fyers.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Positions {
    private String symbol;
    private String id;
    private float buyAvg;
    private float sellAvg;
    private int buyQty;
    private int sellQty;
    private float netAvg;
    private int netQty;
    private int side;
    private int qty;
    private String productType;
    private  float realized_profit;
    private float unrealized_profit;
    private float pl;
    private String crossCurrency;
    private float rbiRefRate;
    private float qtyMulti_com;
    private int segment;
    private int exchange;
    private int slNo;
    private float ltp;
    private String fytoken;
    private int cfBuyQty;
    private int cfSellQty;
    private int dayBuyQty;
    private int daySellQty;
}
