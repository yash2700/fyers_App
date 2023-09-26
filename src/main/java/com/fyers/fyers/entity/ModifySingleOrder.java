package com.fyers.fyers.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModifySingleOrder {
    private String id;
    private float limitPrice;
    private float stopPrice;
    private int qty;
    private int type;
    private int side;

}
