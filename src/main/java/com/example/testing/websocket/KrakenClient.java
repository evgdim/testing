package com.example.testing.websocket;

import org.asynchttpclient.Dsl;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.netty.ws.NettyWebSocket;
import org.asynchttpclient.ws.WebSocket;
import org.asynchttpclient.ws.WebSocketListener;
import org.asynchttpclient.ws.WebSocketUpgradeHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

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

}
