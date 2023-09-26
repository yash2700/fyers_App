package com.fyers.fyers.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fyers.fyers.dto.HistoryDto;
import com.fyers.fyers.entity.HistoryData;
import com.fyers.fyers.serviceImpl.HistoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/history")
public class HistoryController {

    final HistoryServiceImpl service;

    public HistoryController(HistoryServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public ResponseEntity<JsonNode> getHistorydata(@RequestBody()HistoryDto historyDto, @RequestParam("appId") String appId) throws JsonProcessingException {
        return new ResponseEntity<>(service.getHistorydata(historyDto,appId), HttpStatus.OK);
    }
}
