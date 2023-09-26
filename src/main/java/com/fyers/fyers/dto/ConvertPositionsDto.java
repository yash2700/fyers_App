package com.fyers.fyers.dto;

import com.fyers.fyers.entity.ConvertPositions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConvertPositionsDto {
    private String symbol;
    private int positionsSide;
    private int convertQty;
    private String convertFrom;
    private String convertTo;
    public static ConvertPositions toEntity(ConvertPositionsDto positionsDto){
        return ConvertPositions.builder()
                .symbol(positionsDto.getSymbol())
                .positionSide(positionsDto.getConvertQty())
                .convertTo(positionsDto.getConvertTo())
                .convertFrom(positionsDto.getConvertFrom())
                .convertQty(positionsDto.getConvertQty())
                .build();
    }
}
