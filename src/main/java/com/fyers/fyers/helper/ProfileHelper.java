package com.fyers.fyers.helper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fyers.fyers.dto.FundsDto;
import com.fyers.fyers.dto.HoldingsDto;
import com.fyers.fyers.dto.OverAllHoldingsDto;
import com.fyers.fyers.dto.ProfileDto;
import com.fyers.fyers.entity.Profile;
import com.fyers.fyers.enums.ExceptionConstants;
import com.fyers.fyers.exceptions.GenericException;
import com.fyers.fyers.response.HoldingsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfileHelper {
    @Value("${profile_url}")
    private String profile_url;
    @Value("${funds_url}")
    private String funds_url;
    @Value("${holdings_url}")
    private String holdings_url;

    @Autowired
    WebClient webClient;

    ObjectMapper objectMapper=new ObjectMapper();

    public ProfileDto getProfile(String appIdToken) throws JsonProcessingException {
        try {


        String response=webClient.get().uri(profile_url)
                .header("Authorization",appIdToken)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println(response);
        JsonNode jsonNode=objectMapper.readTree(response);
        Profile profile=objectMapper.readValue(jsonNode.get("data").toString(), Profile.class);
        System.out.println(profile);
        return ProfileDto.generateDto(profile);
        }
        catch (Exception e){
            throw new GenericException(ExceptionConstants.Generic_Exception);
        }
    }

    public List<FundsDto> getFunds(String appIdToken) throws JsonProcessingException {
        try {


        String response=webClient.get().uri(funds_url)
                .header("Authorization",appIdToken)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(response);
        JsonNode node=objectMapper.readTree(response).get("fund_limit");
//        List<Funds> fundsList=objectMapper.readValue(node.get("fund_limit").toString(),
//                new TypeReference<List<Funds>>() {}
//        );
        List<FundsDto> fundsdto=new ArrayList<>();
        for (JsonNode i:node){
            FundsDto fundsDto=objectMapper.treeToValue(i, FundsDto.class);
            fundsdto.add(fundsDto);
        }
        System.out.println(fundsdto);
        return fundsdto;
        }
        catch (Exception e){
            throw new GenericException(ExceptionConstants.Generic_Exception);
        }
    }

    public HoldingsResponse getHoldings(String  appIdToken) throws JsonProcessingException {
        try {


        String response=webClient.get().uri(holdings_url)
                .header("Authorization",appIdToken)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JsonNode holdingsNode=objectMapper.readTree(response).get("holdings");
        List<HoldingsDto> holdingsDtoList=new ArrayList<>();
        holdingsDtoList=objectMapper.readValue(holdingsNode.toString(), new TypeReference<List<HoldingsDto>>() {
        });
        System.out.println(holdingsDtoList);

        JsonNode overallPortfolio=objectMapper.readTree(response).get("overall");
        OverAllHoldingsDto overAllHoldingsDto=objectMapper.readValue(overallPortfolio.toString(),OverAllHoldingsDto.class);
        System.out.println(overAllHoldingsDto);

        HoldingsResponse holdingsResponse= HoldingsResponse.builder()
                .holdingsDtoList(holdingsDtoList)
                .overAllHoldingsDto(overAllHoldingsDto)
                .build();

        return holdingsResponse;
        }
        catch (Exception e){
            throw new GenericException(ExceptionConstants.Generic_Exception);
        }
    }
}
