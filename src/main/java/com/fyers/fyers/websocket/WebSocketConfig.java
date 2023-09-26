package com.fyers.fyers.websocket;

import com.fyers.fyers.config.RedisConfig;
import com.fyers.fyers.helper.QuoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    QuoteHelper helper;

    @Autowired
    RedisConfig redisConfig;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new DataWebSocketHandler(helper, redisConfig), "/data").setAllowedOrigins("*");
    }
}