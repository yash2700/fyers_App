package com.fyers.fyers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OverAllHoldingsDto {
    private int count_total;
    private float total_investment;
    private float total_current_value;
    private float total_pl;
    private float pnl_perc;
}
