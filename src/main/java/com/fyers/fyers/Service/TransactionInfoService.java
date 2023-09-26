package com.fyers.fyers.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fyers.fyers.dto.OrdersDto;
import com.fyers.fyers.response.PositionsResponse;

import java.util.List;

public interface TransactionInfoService {
    List<OrdersDto> getOrders(String appId) throws JsonProcessingException;
    PositionsResponse getPositions(String appId) throws JsonProcessingException;
}
