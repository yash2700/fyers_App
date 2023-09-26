package com.fyers.fyers.dto;

import com.fyers.fyers.entity.Funds;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FundsDto {
    private int id;
    private String title;
    private float equityAmount;
    private float commodityAmount;

    public static FundsDto entityToDto(Funds funds){
        return FundsDto.builder()
                .commodityAmount(funds.getCommodityAmount())
                .id(funds.getId())
                .equityAmount(funds.getEquityAmount())
                .title(funds.getTitle())
                .build();
    }
}
