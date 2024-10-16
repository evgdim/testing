package com.example.testing.websocket;

import com.example.testing.websocket.model.OrderBookUpdate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.netty.ws.NettyWebSocket;
import org.asynchttpclient.ws.WebSocket;
import org.asynchttpclient.ws.WebSocketListener;
import org.asynchttpclient.ws.WebSocketUpgradeHandler;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;

public class KrakenClient<T> {
    private final String baseUrl; //"wss://ws.kraken.com/"
    private final String pair; //XBT/USD
    private final Function<String, T> responseMapper;
    private final Integer depth;

    public KrakenClient() {
        this("wss://ws.kraken.com/", "XBT/USD",10, s -> (T)s);
    }

    public KrakenClient(String baseUrl, String pair, Integer depth, Function<String, T> responseMapper) {
        this.baseUrl = baseUrl;
        this.pair = pair;
        this.responseMapper = responseMapper;
        this.depth = depth;
    }

    public void listenOrderBookUpdates(Consumer<T> onBookUpdate) throws InterruptedException, ExecutionException {

        WebSocketUpgradeHandler handler = new WebSocketUpgradeHandler.Builder().addWebSocketListener(new WebSocketListener() {
            @Override
            public void onOpen(WebSocket websocket) {
                if(websocket.isOpen()) {
                    websocket.sendTextFrame("{\"event\": \"subscribe\",\"pair\": [\""+pair+"\"],\"subscription\": {\"name\": \"book\", \"depth\": "+depth+"}}");
                }

            }

            @Override
            public void onTextFrame(String payload, boolean finalFragment, int rsv) {
                System.out.println(payload);
                var mappedResponse = responseMapper.apply(payload);
                onBookUpdate.accept(mappedResponse);
            }

            @Override
            public void onClose(WebSocket websocket, int code, String reason) {

            }

            @Override
            public void onError(Throwable t) {

            }
        }).build();
        ListenableFuture<NettyWebSocket> request = Dsl.asyncHttpClient()
                .prepareGet(baseUrl)
                .execute(handler);
        request.get();
    }

    static class ResponseMapper {
        private static ObjectMapper jackson = new ObjectMapper();

        public static Optional<OrderBookUpdate> mapResponse(String s) {
            try {
                if(isBookUpdate(s)) {
                    OrderBookUpdate obUpdate = jackson.readValue(s, OrderBookUpdate.class);
                    return Optional.of(obUpdate);
                } else return Optional.empty();
            } catch (Exception e) {
                System.out.println(e);
                return Optional.empty();
            }
        }

        private static boolean isBookUpdate(String eventString) {
            if(eventString.equals("{\"event\":\"heartbeat\"}")) return false;
            if(eventString.contains("connectionID")) return false;
            if(eventString.contains("subscriptionStatus")) return false;
            return true;
        }
    }
}
