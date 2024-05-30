package com.example.testing.websocket;

import com.example.testing.websocket.model.OrderBookUpdate;
import com.example.testing.websocket.model.OrderBookUpdateItem;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.netty.ws.NettyWebSocket;
import org.asynchttpclient.ws.WebSocket;
import org.asynchttpclient.ws.WebSocketListener;
import org.asynchttpclient.ws.WebSocketUpgradeHandler;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;

public class KrakenClient<T> {
    private final String baseUrl; //"wss://ws.kraken.com/"
    private final String pair; //XBT/USD
    private final Function<String, T> responseMapper;

    public KrakenClient() {
        this("wss://ws.kraken.com/", "XBT/USD", s -> (T)s);
    }

    public KrakenClient(String baseUrl, String pair, Function<String, T> responseMapper) {
        this.baseUrl = baseUrl;
        this.pair = pair;
        this.responseMapper = responseMapper;
    }

    public Flux<T> orderBookUpdates() {
        Flux<T> flux = Flux.create(fluxSink -> {
            try {
                listenOrderBookUpdates(s -> fluxSink.next(s));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        return flux;
    }

    public void listenOrderBookUpdates(Consumer<T> onBookUpdate) throws InterruptedException, ExecutionException {

        WebSocketUpgradeHandler handler = new WebSocketUpgradeHandler.Builder().addWebSocketListener(new WebSocketListener() {
            @Override
            public void onOpen(WebSocket websocket) {
                if(websocket.isOpen()) {
                    websocket.sendTextFrame("{\"event\": \"subscribe\",\"pair\": [\""+pair+"\"],\"subscription\": {\"name\": \"book\"}}");
                }

            }

            @Override
            public void onTextFrame(String payload, boolean finalFragment, int rsv) {
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
        private static List<OrderBookUpdateItem> mapItems(ArrayNode itemsNode) {
            if(itemsNode == null) return List.of();
            List<OrderBookUpdateItem> items = new ArrayList<>();
            for (int i = 0; i < itemsNode.size(); i++) {
                JsonNode itemNode = itemsNode.get(i);
                var obui =new OrderBookUpdateItem(itemNode.get(0).decimalValue(), itemNode.get(1).decimalValue(), itemNode.get(2).decimalValue());
                items.add(obui);
            }
            return items;
        }

        public static Optional<OrderBookUpdate> mapResponse(String s) {
            try {
                JsonNode jsonNode = jackson.readValue(s, JsonNode.class);
                if(jsonNode.isArray()) {
                    JsonNode book = jsonNode.get(1);
                    String channel = jsonNode.get(2).asText();
                    String pair = jsonNode.get(3).asText();
                    boolean isOrderBookUpdate = book.has("c");
                    Long checksum = null;
                    List<OrderBookUpdateItem> asks;
                    List<OrderBookUpdateItem> bids;
                    if(isOrderBookUpdate) {
                        asks = mapItems((ArrayNode) book.get("a"));
                        bids = mapItems((ArrayNode) book.get("b"));
                        checksum = book.get("c").asLong();
                    } else {
                        asks = mapItems((ArrayNode) book.get("as"));
                        bids = mapItems((ArrayNode) book.get("bs"));
                    }
                    return Optional.of(new OrderBookUpdate(bids, asks, channel, pair, Optional.ofNullable(checksum)));
                }
                return Optional.empty();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
