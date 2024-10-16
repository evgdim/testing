package com.example.testing.websocket;

import com.example.testing.websocket.model.OrderBookItem;
import com.example.testing.websocket.model.OrderBookUpdate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Function<String, Optional<OrderBookUpdate>> mapper = s -> KrakenClient.ResponseMapper.mapResponse(s);
        KrakenClient client = new KrakenClient("wss://ws.kraken.com/", "XBT/USD", 10, mapper); //use 25 even if we need only 10 to handle the case when volume is 0 and we have to remove entry
        LocalOrderBook lob = new LocalOrderBook();
//        while (true) {
            try {
                client.listenOrderBookUpdates((Consumer<Optional<OrderBookUpdate>>) orderBookUpdate -> {
                    if(orderBookUpdate.isPresent()) {
                        OrderBookUpdate obUpdate = orderBookUpdate.get();
                        System.out.println(orderBookUpdate);
                        List<OrderBookItem> bids = obUpdate.getBids();
                        List<OrderBookItem> asks = obUpdate.getAsks();
                        lob.update(bids, asks, obUpdate.getChecksum());
                    }
                });
            } catch (InvalidChecksumException t) {
                System.out.println(t.getMessage());
            }
//        }
    }
}
