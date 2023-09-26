package com.fyers.fyers.helper;

import com.fyers.fyers.enums.ExceptionConstants;
import com.fyers.fyers.exceptions.GenericException;
import com.fyers.fyers.response.quote.QuoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuoteHelper {
    @Value("${quotes_url}")
    private String quotes_url;

    @Autowired
    WebClient webClient;

    public QuoteResponse getQuotes(List<String> list,String appIdToken){
        String symbols=list.stream().collect(Collectors.joining(","));
        try {
            String uri = UriComponentsBuilder.fromUriString(quotes_url)
                    .queryParam("symbols", symbols)
                    .build().toUriString();
            QuoteResponse response = webClient.get().uri(uri)
                    .header("Authorization", appIdToken)
                    .retrieve().bodyToMono(QuoteResponse.class)
                    .block();
            return response;
        }
        catch (Exception e) {
            throw new GenericException(ExceptionConstants.Generic_Exception);
        }
    }
}
