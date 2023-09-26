package com.fyers.fyers.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Candles {
    private long timestamp;
    private double open;
    private double low;
    private double high;
    private double close;
    private long volume;

    public Candles(long timestamp, double open, double high, double low, double close, long volume) {
        this.timestamp=timestamp;
        this.close=close;
        this.high=high;
        this.low=low;
        this.open=open;
        this.volume=volume;

    }

//    public static Candles toEntity(String timestamp,String open,String high,String low, String close, String volume){
//        return Candles.builder()
//                .timestamp(timestamp)
//                .open(open)
//                .high(high)
//                .low(low)
//                .close(close)
//                .volume(volume)
//                .build();
//    }
}
