package com.fyers.fyers.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fyers.fyers.dto.*;
import com.fyers.fyers.response.PositionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class TransactionHelper {
    @Autowired
    WebClient webClient;
    @Value("${orders_url}")
    private String orders_url;
    @Value("${positions_url}")
    private String positions_url;

    ObjectMapper objectMapper=new ObjectMapper();

    public List<OrdersDto> getOrders(String appIdToken) throws JsonProcessingException {
        String response=webClient.get().uri(orders_url)
                .header("Authorization",appIdToken)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JsonNode node=objectMapper.readTree(response).get("orderBook");
        List<OrdersDto> ordersDtos=objectMapper.readValue(node.toString(),new TypeReference<List<OrdersDto>>() {});
        return ordersDtos;
    }

    public PositionsResponse  getPositions(String appIdToken) throws JsonProcessingException {
        String response=webClient.get().uri(positions_url)
                .header("Authorization",appIdToken)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JsonNode tree=objectMapper.readTree(response);
        JsonNode node=tree.get("netPositions");
        List<Positions> positions =objectMapper.readValue(node.toString(), new TypeReference<List<Positions>>() {
        });

        JsonNode overAllPositionsNode=tree.get("overall");
        OverAllPositions overAllPositions=objectMapper.readValue(overAllPositionsNode.toString(),OverAllPositions.class);

        return PositionsResponse.builder()
                .overAllPositions(overAllPositions)
                .positions(positions)
                .build();
    }

}

