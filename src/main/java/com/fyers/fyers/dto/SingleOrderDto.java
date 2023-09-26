package com.fyers.fyers.dto;

import com.fyers.fyers.entity.SingleOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SingleOrderDto {
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

    public static SingleOrder toEntity(SingleOrderDto singleOrderDto){
        return SingleOrder.builder()
                .symbol(singleOrderDto.getSymbol())
                .qty(singleOrderDto.qty)
                .type(singleOrderDto.getType())
                .side(singleOrderDto.getSide())
                .productType(singleOrderDto.getProductType())
                .limitPrice(singleOrderDto.getLimitPrice())
                .stopPrice(singleOrderDto.getStopPrice())
                .disclosedQty(singleOrderDto.getDisclosedQty())
                .validity(singleOrderDto.getValidity())
                .offlineOrder(singleOrderDto.getOfflineOrder())
                .stopLoss(singleOrderDto.stopLoss)
                .takeProfit(singleOrderDto.getTakeProfit())
                .build();
    }
}
