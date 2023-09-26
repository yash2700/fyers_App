package com.fyers.fyers.serviceImpl;

import com.fyers.fyers.Service.PositionsService;
import com.fyers.fyers.config.RedisConfig;
import com.fyers.fyers.dto.ConvertPositionsDto;
import com.fyers.fyers.entity.ConvertPositions;
import com.fyers.fyers.enums.ExceptionConstants;
import com.fyers.fyers.exceptions.AccessTokenNotFoundException;
import com.fyers.fyers.helper.PositionsHelper;
import com.fyers.fyers.response.ExitPositionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionsServiceImpl implements PositionsService {
    final
    RedisConfig redisConfig;

    final
    PositionsHelper positionsHelper;

    public PositionsServiceImpl(RedisConfig redisConfig, PositionsHelper positionsHelper) {
        this.redisConfig = redisConfig;
        this.positionsHelper = positionsHelper;
    }

    @Override
    public ExitPositionResponse exitPosition(List<String> list, String appId) {
        String token = redisConfig.getValueByKey(appId+"accessToken");
        if (token == null) {
            throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);
        }
        return positionsHelper.exitPositions(list,appId+":"+token);
    }

    @Override
    public ExitPositionResponse convertPosition(ConvertPositionsDto positionsDto, String appId) {
        String token = redisConfig.getValueByKey(appId+"accessToken");
        if (token == null) {
            throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);
        }
        ConvertPositions convertPositions=ConvertPositionsDto.toEntity(positionsDto);
        return positionsHelper.convertPositions(convertPositions,appId+":"+token);
    }
}
