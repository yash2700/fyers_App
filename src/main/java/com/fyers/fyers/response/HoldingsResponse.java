package com.fyers.fyers.response;

import com.fyers.fyers.dto.HoldingsDto;
import com.fyers.fyers.dto.OverAllHoldingsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HoldingsResponse {
    private List<HoldingsDto> holdingsDtoList;
    private OverAllHoldingsDto overAllHoldingsDto;
}
