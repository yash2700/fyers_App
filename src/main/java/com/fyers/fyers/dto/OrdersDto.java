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
public class OrdersDto {
    private String id;
    private String exchOrdId;
    private String symbol;
    private int qty;
    private int remainingQuantity;
    private int filledQty;
    private String description;
    private int status;
    private int slNo;
    private String message;
    private int segment;
    private float limitPrice;
    private  float stopPrice;
    private String productType;
    private int type;
    private int side;
    private int disclosedQty;
    private String orderValidity;
    private String orderDateTime;
    private String parentId;
    private float tradedPrice;
    private String source;
    private float ch;
    private  String fyToken;
    private boolean offlineOrder;
    private String pan;
    private String  clientId;
    private int exchange;
    private int instrument;
    private int discloseQty;
    private String ex_sym;

}
