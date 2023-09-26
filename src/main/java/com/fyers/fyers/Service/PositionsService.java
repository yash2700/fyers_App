package com.fyers.fyers.Service;

import com.fyers.fyers.dto.ConvertPositionsDto;
import com.fyers.fyers.response.ExitPositionResponse;

import java.util.List;

public interface PositionsService {
        ExitPositionResponse exitPosition(List<String> list, String appId);
        ExitPositionResponse convertPosition(ConvertPositionsDto positionsDto,String appId);
}
