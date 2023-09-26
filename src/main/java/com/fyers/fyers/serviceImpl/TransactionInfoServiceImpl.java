package com.fyers.fyers.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fyers.fyers.Service.TransactionInfoService;
import com.fyers.fyers.config.RedisConfig;
import com.fyers.fyers.dto.OrdersDto;
import com.fyers.fyers.enums.ExceptionConstants;
import com.fyers.fyers.exceptions.AccessTokenNotFoundException;
import com.fyers.fyers.helper.TransactionHelper;
import com.fyers.fyers.response.PositionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionInfoServiceImpl implements TransactionInfoService {
    @Autowired
    RedisConfig redisConfig;

    @Autowired
    TransactionHelper helper;

    @Override
    public List<OrdersDto> getOrders(String appId) throws JsonProcessingException {
        String token=redisConfig.getValueByKey(appId+"accessToken");
        if (token==null)
            throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);
            return helper.getOrders(appId+":"+token);
    }

    @Override
    public PositionsResponse getPositions(String appId) throws JsonProcessingException {
        String token=redisConfig.getValueByKey(appId+"accessToken");
        if (token==null)
            throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);
        return helper.getPositions(appId+":"+token);
    }
}
