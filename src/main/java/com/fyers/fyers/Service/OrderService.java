package com.fyers.fyers.Service;

import com.fyers.fyers.dto.ModifySingleOrderDto;
import com.fyers.fyers.dto.MultiOrdersDto;
import com.fyers.fyers.dto.SingleOrderDto;
import com.fyers.fyers.response.ModifySingleOrderResponse;
import com.fyers.fyers.response.MultiOrderResponse;
import com.fyers.fyers.response.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(SingleOrderDto singleOrderDto,String appId);
    MultiOrderResponse placeMultiOrder(MultiOrdersDto multiOrdersDto,String appId);
    ModifySingleOrderResponse modifySingleOrder(ModifySingleOrderDto modifySingleOrderDto,String appId);
    String cancelSingleOrder(String id,String appId);
}
