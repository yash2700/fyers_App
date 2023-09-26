package com.fyers.fyers.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fyers.fyers.dto.OrdersDto;
import com.fyers.fyers.response.PositionsResponse;
import com.fyers.fyers.serviceImpl.TransactionInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionInfoController {

    @Autowired
    TransactionInfoServiceImpl service;

    @GetMapping(value = "/getOrders")
    public ResponseEntity<List<OrdersDto>> getOrders(@RequestParam("appId") String  appId) throws JsonProcessingException {
        return new ResponseEntity<>(service.getOrders(appId), HttpStatus.OK);
    }

    @GetMapping("/getPositions")
    public ResponseEntity<PositionsResponse> getPositions(@RequestParam("appId") String  appId) throws JsonProcessingException {
        return new ResponseEntity<>(service.getPositions(appId),HttpStatus.OK);
    }
}
