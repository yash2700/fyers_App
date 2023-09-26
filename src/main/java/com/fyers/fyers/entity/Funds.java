package com.fyers.fyers.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funds {
    private int id;
    private String title;
    private float equityAmount;
    private float commodityAmount;
}
