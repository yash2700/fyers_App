package com.fyers.fyers.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fyers.fyers.dto.FundsDto;
import com.fyers.fyers.dto.ProfileDto;
import com.fyers.fyers.response.HoldingsResponse;

import java.util.List;

public interface ProfileService {
        ProfileDto getProfile(String appId) throws JsonProcessingException;

        List<FundsDto> getFunds(String appId) throws JsonProcessingException;
        HoldingsResponse getHoldings(String appId) throws JsonProcessingException;
}
