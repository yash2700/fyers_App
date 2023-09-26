package com.fyers.fyers.websocket;

import com.fyers.fyers.config.RedisConfig;
import com.fyers.fyers.helper.QuoteHelper;
import com.fyers.fyers.response.quote.QuoteResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DataWebSocketHandler extends TextWebSocketHandler {

    final
    QuoteHelper helper;

    final RedisConfig config;
    private final Map<WebSocketSession, Thread> sendingThreads = new ConcurrentHashMap<>();

    public DataWebSocketHandler(QuoteHelper helper, RedisConfig config) {
        this.helper = helper;
        this.config = config;
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        stopSendingHi(session);
    }
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String receivedMessage = message.getPayload();
        startSendingMessage(session, receivedMessage);
    }

    private void startSendingMessage(WebSocketSession session, String message) {
        Thread sendingThread = new Thread(() -> {
            String[] arr=message.split(",");
            List<String> symbol=new ArrayList<>();
            symbol.add(arr[0]);
            System.out.println();
           String token=arr[1]+":"+config.getValueByKey(arr[1]+"accessToken");

            while (session.isOpen()) {
                try {
                 QuoteResponse response= helper.getQuotes(symbol,token);
                    // Send the received message every 1 second
                    sendDataToClient(response.toString(), session);

                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
        sendingThreads.put(session, sendingThread);
        sendingThread.start();
    }

    private void stopSendingHi(WebSocketSession session) {
        Thread sendingThread = sendingThreads.get(session);
        if (sendingThread != null) {
            sendingThread.interrupt();
            sendingThreads.remove(session);
        }
    }

    private void sendDataToClient(String data, WebSocketSession session) throws IOException {
        try {
            session.sendMessage(new TextMessage(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
