package com.fyers.fyers.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fyers.fyers.dto.HistoryDto;
import com.fyers.fyers.entity.Candles;
import com.fyers.fyers.enums.ExceptionConstants;
import com.fyers.fyers.enums.HistoryDataParams;
import com.fyers.fyers.exceptions.GenericException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryHelper {
    final
    WebClient webClient;

    @Value("${history_url}")
    private String history_url;

    public HistoryHelper(WebClient webClient) {
        this.webClient = webClient;
    }

    public  JsonNode getHistorydata(HistoryDto historyDto, String appIdToken) throws JsonProcessingException {
        String uri = UriComponentsBuilder.fromUriString(history_url)
                .queryParam(HistoryDataParams.SYMBOL.getValue(), historyDto.getSymbol())
                .queryParam(HistoryDataParams.RESOLUTION.getValue(), historyDto.getResolution())
                .queryParam(HistoryDataParams.DATE_FORMAT.getValue(), historyDto.getDate_format())
                .queryParam(HistoryDataParams.RANGE_FROM.getValue(), historyDto.getRange_from())
                .queryParam(HistoryDataParams.RANGE_TO.getValue(), historyDto.getRange_to())
                .queryParam(HistoryDataParams.CONT_FLAG.getValue(), historyDto.getCont_flag())
                .build()
                .toUriString();
        System.out.println(uri);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", appIdToken);
        HttpEntity entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = null;
        try {
             response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        }
        catch (Exception e){
            throw  new GenericException(ExceptionConstants.Generic_Exception);
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.getBody());

        List<Candles> candles = new ArrayList<>();
    return node.get("candles");
//        JsonNode candlesNode = node.get("candles");
//        if (candlesNode != null && candlesNode.isArray()) {
//            for (JsonNode candle : candlesNode) {
//                if (candle.isArray() && candle.size() == 6) {
//                    long timestamp = candle.get(0).asLong();
//                    double open = candle.get(1).asDouble();
//                    double high = candle.get(2).asDouble();
//                    double low = candle.get(3).asDouble();
//                    double close = candle.get(4).asDouble();
//                    long volume = candle.get(5).asLong();
//
//                    candles.add(new Candles(timestamp, open, high, low, close, volume));
//                }
//            }
//        }
//
//        HistoryData data = HistoryData.builder()
//                .s(String.valueOf(node.get("s")))
//                .candles(candles)
//                .build();
//
//        return data;
//        ResponseEntity<String > response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
//
//        ObjectMapper mapper=new ObjectMapper();
//        JsonNode node=mapper.readTree(response.getBody());
//
//        List<Candles> candles=new ArrayList<>();
//
//       node.get("candles").forEach(i->{
//           List<Object> candleData = mapper.convertValue(i, List.class);
//           candles.add(
//                new Candles( candleData.get(0).toString(), candleData.get(1).toString(),
//                        candleData.get(2).toString(), candleData.get(3).toString(),
//                        candleData.get(4).toString(), candleData.get(5).toString())
//           );
//       });
//        HistoryData data=HistoryData.builder()
//                .s(String.valueOf(node.get("s")))
//                .candles(candles)
//                .build();
//        return data;
//        return null;
   }
}
