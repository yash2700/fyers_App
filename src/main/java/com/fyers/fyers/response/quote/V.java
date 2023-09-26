package com.fyers.fyers.response.quote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class V {
    public double ch;
    public double chp;
    public double lp;
    public double spread;
    public double ask;
    public double bid;
    public double open_price;
    public double high_price;
    public double low_price;
    public double prev_close_price;
    public int volume;
    public String short_name;
    public String exchange;
    public String description;
    public String original_name;
    public String symbol;
    public String fyToken;
    public String tt;
    public Cmd cmd;
}
