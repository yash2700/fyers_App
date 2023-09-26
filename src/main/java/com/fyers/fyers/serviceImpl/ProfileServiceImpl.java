package com.fyers.fyers.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fyers.fyers.Service.ProfileService;
import com.fyers.fyers.config.RedisConfig;
import com.fyers.fyers.dto.FundsDto;
import com.fyers.fyers.dto.ProfileDto;
import com.fyers.fyers.enums.ExceptionConstants;
import com.fyers.fyers.exceptions.AccessTokenNotFoundException;
import com.fyers.fyers.helper.ProfileHelper;
import com.fyers.fyers.response.HoldingsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    RedisConfig redisConfig;
    @Autowired
    ProfileHelper profileHelper;

    @Override
    public ProfileDto getProfile(String appId) throws JsonProcessingException {
            String token=redisConfig.getValueByKey(appId+"accessToken");
            if(token==null)
                throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);
            return profileHelper.getProfile(appId+":"+token);
    }

    @Override
    public List<FundsDto> getFunds(String appId) throws JsonProcessingException {
        String token=redisConfig.getValueByKey(appId+"accessToken");
        if (token==null) throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);

        return profileHelper.getFunds(appId+":"+token);
    }

    @Override
    public HoldingsResponse getHoldings(String appId) throws JsonProcessingException {
        String token=redisConfig.getValueByKey(appId+"accessToken");
        if (token==null) throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);
        return profileHelper.getHoldings(appId+":"+token);
    }
}
