package com.fyers.fyers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryDto {
    private String symbol;
    private String resolution;
    private String date_format;
    private String range_from;
    private String range_to;
    private String cont_flag;
}
