package com.example.testing.websocket;

import com.example.testing.websocket.model.OrderBookUpdate;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Function<String, Optional<OrderBookUpdate>> mapper = s -> KrakenClient.ResponseMapper.mapResponse(s);
        KrakenClient client = new KrakenClient("wss://ws.kraken.com/", "XBT/USD", mapper);
        LocalOrderBook lob = new LocalOrderBook();
        while (true) {
            try {
                client.listenOrderBookUpdates((Consumer<Optional<OrderBookUpdate>>) orderBookUpdate -> {
                    if(orderBookUpdate.isPresent()) {
                        OrderBookUpdate obUpdate = orderBookUpdate.get();
                        System.out.println(orderBookUpdate);
                        lob.update(obUpdate.getAsks(), obUpdate.getAsks(), obUpdate.getChecksum());
                    }
                });
            } catch (InvalidChecksumException t) {
                System.out.println(t.getMessage());
            }
        }
    }
}
