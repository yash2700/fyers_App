package com.fyers.fyers.dto;

import com.fyers.fyers.entity.MultiOrder;
import com.fyers.fyers.entity.SingleOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MultiOrdersDto {
    private List<SingleOrder> orderList;

    public static MultiOrder toEntity(MultiOrdersDto multiOrdersDto){
        return MultiOrder.builder()
                .orderList(multiOrdersDto.getOrderList())
                .build();
    }

}
