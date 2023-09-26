package com.fyers.fyers.serviceImpl;

import com.fyers.fyers.Service.OrderService;
import com.fyers.fyers.config.RedisConfig;
import com.fyers.fyers.dto.ModifySingleOrderDto;
import com.fyers.fyers.dto.MultiOrdersDto;
import com.fyers.fyers.dto.SingleOrderDto;
import com.fyers.fyers.entity.ModifySingleOrder;
import com.fyers.fyers.entity.MultiOrder;
import com.fyers.fyers.entity.SingleOrder;
import com.fyers.fyers.enums.ExceptionConstants;
import com.fyers.fyers.exceptions.AccessTokenNotFoundException;
import com.fyers.fyers.helper.OrderHelper;
import com.fyers.fyers.response.ModifySingleOrderResponse;
import com.fyers.fyers.response.MultiOrderResponse;
import com.fyers.fyers.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    RedisConfig redisConfig;
    @Autowired
    OrderHelper orderHelper;

    @Override
    public OrderResponse placeOrder(SingleOrderDto singleOrderDto,String appId) {
        String token= redisConfig.getValueByKey(appId+"accessToken");
        if(token==null)
            throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);
        SingleOrder singleOrder=SingleOrderDto.toEntity(singleOrderDto);
        return orderHelper.placeSingleOrder(singleOrder,appId+":"+token);
    }

    @Override
    public MultiOrderResponse placeMultiOrder(MultiOrdersDto multiOrdersDto, String appId) {
        String token = redisConfig.getValueByKey(appId + "accessToken");
        if (token == null)
            throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);


        MultiOrder multiOrder=MultiOrdersDto.toEntity(multiOrdersDto);
        return orderHelper.placeMultiOrder(multiOrder,appId+":"+token);
    }

    @Override
    public ModifySingleOrderResponse modifySingleOrder(ModifySingleOrderDto modifySingleOrderDto, String appId) {
        String token = redisConfig.getValueByKey(appId + "accessToken");
        if (token == null)
            throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);

        ModifySingleOrder modifySingleOrder=ModifySingleOrderDto.toEntity(modifySingleOrderDto);
        return orderHelper.modifySingleOrder(modifySingleOrder,appId+":"+token);
    }

    @Override
    public String cancelSingleOrder(String id, String appId) {
        String token = redisConfig.getValueByKey(appId + "accessToken");
        if (token == null)
            throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);

        return orderHelper.cancelSingleOrder(id,appId+":"+token);
    }
}
