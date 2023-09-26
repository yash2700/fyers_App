package com.fyers.fyers.response;

import com.fyers.fyers.dto.OverAllPositions;
import com.fyers.fyers.dto.Positions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PositionsResponse {
    private List<Positions> positions;
    private OverAllPositions overAllPositions;
}
