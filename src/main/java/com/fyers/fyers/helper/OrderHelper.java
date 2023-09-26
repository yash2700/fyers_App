package com.fyers.fyers.helper;

import com.fyers.fyers.entity.ModifySingleOrder;
import com.fyers.fyers.entity.MultiOrder;
import com.fyers.fyers.entity.SingleOrder;
import com.fyers.fyers.enums.ExceptionConstants;
import com.fyers.fyers.exceptions.GenericException;
import com.fyers.fyers.response.ModifySingleOrderResponse;
import com.fyers.fyers.response.MultiOrderResponse;
import com.fyers.fyers.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class OrderHelper {
    @Autowired
    WebClient webClient;

    @Value("${order_url}")
    private String order_url;

    @Value("${multi_order_url}")
    private String multi_order_url;

    public OrderResponse placeSingleOrder(SingleOrder singleOrder, String appIdToken) {
        try {
            OrderResponse orderResponse = webClient.post()
                    .uri(order_url)
                    .header("Authorization", appIdToken)
                    .body(Mono.just(singleOrder), SingleOrder.class)
                    .retrieve()
                    .bodyToMono(OrderResponse.class)
                    .block();
            return orderResponse;
        }
        catch (Exception e){
            throw new GenericException(ExceptionConstants.Generic_Exception);
        }
    }

    public MultiOrderResponse placeMultiOrder(MultiOrder multiOrder,String appIdToken){
        try {


        MultiOrderResponse multiOrderResponse=webClient.post()
                .uri(multi_order_url)
                .header("Authorization",appIdToken)
                .body(multiOrder, MultiOrder.class)
                .retrieve()
                .bodyToMono(MultiOrderResponse.class)
                .block();
        return multiOrderResponse;
        }
        catch (Exception e){
            throw new GenericException(ExceptionConstants.Generic_Exception);
        }
    }

    public ModifySingleOrderResponse modifySingleOrder(ModifySingleOrder modifySingleOrder,String appIdToken){
        try {


        ModifySingleOrderResponse response=webClient.put()
                .uri(order_url)
                .header("Authorization",appIdToken)
                .body(modifySingleOrder, ModifySingleOrder.class)
                .retrieve()
                .bodyToMono(ModifySingleOrderResponse.class)
                .block();
        return response;
        }
        catch (Exception e){
            throw new GenericException(ExceptionConstants.Generic_Exception);
        }
    }

    public String cancelSingleOrder(String id,String appIdToken){
        try {


        String response=webClient.delete().uri(order_url)
                .header("Authorization",appIdToken)
                .attribute("id",id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
        }
        catch (Exception e){
            throw new GenericException(ExceptionConstants.Generic_Exception);
        }
    }
}
