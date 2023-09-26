package com.fyers.fyers.dto;

import com.fyers.fyers.entity.ModifySingleOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModifySingleOrderDto {
    private String id;
    private float limitPrice;
    private float stopPrice;
    private int qty;
    private int type;
    private int side;

    public static ModifySingleOrder toEntity(ModifySingleOrderDto orderDto){
        return ModifySingleOrder.builder()
                .id(orderDto.getId())
                .limitPrice(orderDto.getLimitPrice())
                .stopPrice(orderDto.getStopPrice())
                .qty(orderDto.getQty())
                .type(orderDto.getType())
                .side(orderDto.getSide())
                .build();

    }
}
