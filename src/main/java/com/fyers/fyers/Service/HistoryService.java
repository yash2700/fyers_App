package com.fyers.fyers.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fyers.fyers.dto.HistoryDto;

public interface HistoryService {
    JsonNode getHistorydata(HistoryDto historyDto, String appId) throws JsonProcessingException;
}
