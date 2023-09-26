package com.fyers.fyers.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fyers.fyers.Service.HistoryService;
import com.fyers.fyers.config.RedisConfig;
import com.fyers.fyers.dto.HistoryDto;
import com.fyers.fyers.entity.HistoryData;
import com.fyers.fyers.enums.ExceptionConstants;
import com.fyers.fyers.exceptions.AccessTokenNotFoundException;
import com.fyers.fyers.helper.HistoryHelper;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService {
    final
    RedisConfig redisConfig;

    final
    HistoryHelper helper;

    public HistoryServiceImpl(RedisConfig redisConfig, HistoryHelper helper) {
        this.redisConfig = redisConfig;
        this.helper = helper;
    }

    @Override
    public JsonNode getHistorydata(HistoryDto historyDto, String appId) throws JsonProcessingException {
        String  token= redisConfig.getValueByKey(appId+"accessToken");
        if (token==null)
            throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);

        return helper.getHistorydata(historyDto,appId+":"+token);
    }
}
