package com.fyers.fyers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OverAllPositions {
    private int count_total;
    private int count_open;
    private float pl_total;
    private float pl_realized;
    private float pl_unrealized;


}
