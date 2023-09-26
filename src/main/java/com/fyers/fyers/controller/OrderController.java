package com.fyers.fyers.controller;

import com.fyers.fyers.dto.ModifySingleOrderDto;
import com.fyers.fyers.dto.MultiOrdersDto;
import com.fyers.fyers.dto.SingleOrderDto;
import com.fyers.fyers.response.ModifySingleOrderResponse;
import com.fyers.fyers.response.MultiOrderResponse;
import com.fyers.fyers.response.OrderResponse;
import com.fyers.fyers.serviceImpl.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    final
    OrderServiceImpl service;

    public OrderController(OrderServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/single")
    public ResponseEntity<OrderResponse> placeSingleOrder(@RequestBody()SingleOrderDto singleOrderDto, @RequestParam("appId") String appId){
        return new ResponseEntity<>(service.placeOrder(singleOrderDto,appId), HttpStatus.OK);
    }

    @PostMapping(value = "/multi")
    public ResponseEntity<MultiOrderResponse> placeMultiOrders(@RequestBody()MultiOrdersDto multiOrdersDto,@RequestParam("appId") String appId){
        return new ResponseEntity<>(service.placeMultiOrder(multiOrdersDto,appId),HttpStatus.OK);
    }

    @PutMapping(value = "/modify/single")
    public ResponseEntity<ModifySingleOrderResponse> modifySingleOrder(@RequestBody()ModifySingleOrderDto modifySingleOrderDto,@RequestParam("appId") String  appId){
        return new ResponseEntity<>(service.modifySingleOrder(modifySingleOrderDto,appId),HttpStatus.OK);
    }

    @DeleteMapping(value = "/single/cancel")
    public ResponseEntity<String> cancelSingleOrder(@RequestParam("id") String id,@RequestParam("appId")String appId){
        return new ResponseEntity<>(service.cancelSingleOrder(id,appId),HttpStatus.GONE);
    }
}
