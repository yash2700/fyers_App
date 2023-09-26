package com.fyers.fyers.serviceImpl;

import com.fyers.fyers.Service.QuoteService;
import com.fyers.fyers.config.RedisConfig;
import com.fyers.fyers.enums.ExceptionConstants;
import com.fyers.fyers.exceptions.AccessTokenNotFoundException;
import com.fyers.fyers.helper.QuoteHelper;
import com.fyers.fyers.response.quote.QuoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuoteServiceImpl implements QuoteService {
    @Autowired
    RedisConfig redisConfig;
    @Autowired
    QuoteHelper quoteHelper;
    @Override
    public QuoteResponse getQuote(List<String> list, String appId) {
        String token= redisConfig.getValueByKey(appId+"accessToken");
        if (token==null)
            throw new AccessTokenNotFoundException(ExceptionConstants.Access_Token_NotFound);
        return quoteHelper.getQuotes(list,appId+":"+token);

    }
}
