package com.fyers.fyers.Service;

import com.fyers.fyers.response.quote.QuoteResponse;

import java.util.List;

public interface QuoteService {
        QuoteResponse getQuote(List<String> list,String appId);
}
