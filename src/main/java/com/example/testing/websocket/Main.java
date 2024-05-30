package com.example.testing.websocket;

import com.example.testing.websocket.model.OrderBookUpdate;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Function<String, Optional<OrderBookUpdate>> mapper = s -> KrakenClient.ResponseMapper.mapResponse(s);
        KrakenClient client = new KrakenClient("wss://ws.kraken.com/", "XBT/USD", mapper);
        client.orderBookUpdates().subscribe(o -> System.out.println("from flux:" + o));

        Thread.sleep(999999999999L);
    }
}
