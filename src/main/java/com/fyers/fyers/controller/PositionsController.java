package com.fyers.fyers.controller;

import com.fyers.fyers.dto.ConvertPositionsDto;
import com.fyers.fyers.response.ExitPositionResponse;
import com.fyers.fyers.serviceImpl.PositionsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/positions")
public class PositionsController {
    final PositionsServiceImpl service;

    public PositionsController(PositionsServiceImpl service){
        this.service=service;
    }

    @DeleteMapping(value = "/exit")
    public ResponseEntity<ExitPositionResponse> exitsPositions(@RequestBody()List<String> id, @RequestParam("appId") String appId){
        return new ResponseEntity<>(service.exitPosition(id,appId), HttpStatus.GONE);
    }

    @PutMapping(value = "/convert")
    public ResponseEntity<ExitPositionResponse> convertPosition(@RequestBody()ConvertPositionsDto positionsDto,@RequestParam("appId") String appId){
        return new ResponseEntity<>(service.convertPosition(positionsDto,appId),HttpStatus.ACCEPTED);
    }


}
