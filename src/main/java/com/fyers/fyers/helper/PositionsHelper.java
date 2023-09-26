package com.fyers.fyers.helper;

import com.fyers.fyers.entity.ConvertPositions;
import com.fyers.fyers.enums.ExceptionConstants;
import com.fyers.fyers.exceptions.GenericException;
import com.fyers.fyers.response.ExitPositionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PositionsHelper {
    @Value("${positions_url}")
    private String positions_url;

    @Autowired
    WebClient webClient;

    public ExitPositionResponse exitPositions(List<String> list, String appIdToken){
        Map<String ,List<String >> ids=new HashMap<>();
        ids.put("id",list);
        try {


        ExitPositionResponse response=webClient.method(HttpMethod.DELETE).uri(positions_url)
                .header("Authorization",appIdToken)
                .body(BodyInserters.fromValue(ids))
                .retrieve()
                .bodyToMono(ExitPositionResponse.class)
                .block();
        return response;
        }
        catch (Exception e){
            throw new GenericException(ExceptionConstants.Generic_Exception);
        }

    }

    public ExitPositionResponse convertPositions(ConvertPositions positions,String appIDToken){
        try {


        ExitPositionResponse response=webClient.put().uri(positions_url)
                .header("Authorization",appIDToken)
                .body(Mono.just(positions), ConvertPositions.class)
                .retrieve()
                .bodyToMono(ExitPositionResponse.class)
                .block();
        return response;
        }
        catch (Exception e){
            throw new GenericException(ExceptionConstants.Generic_Exception);
        }
    }
}
