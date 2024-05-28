package com.example.testing.websocket;

import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        KrakenClient client = new KrakenClient("wss://ws.kraken.com/", "XBT/USD", s -> s);
        client.orderBookUpdates().subscribe(o -> System.out.println("from flux:" + o));

        Thread.sleep(999999999999L);
    }
}
