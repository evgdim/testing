package com.example.testing.websocket;

import com.example.testing.websocket.model.OrderBookItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.CRC32;

import static java.util.Comparator.*;

public class LocalOrderBook {
    private final List<OrderBookItem> bids;
    private final List<OrderBookItem> asks;

    public LocalOrderBook() {
        this.bids = new ArrayList<>();
        this.asks = new ArrayList<>();
    }

    public boolean update(List<OrderBookItem> bids, List<OrderBookItem> asks, Long checksum) {
        String asksStringForChecksum = getStringForChecksum(asks.stream().sorted(comparing(OrderBookItem::price)));
        String bidsStringForChecksum = getStringForChecksum(bids.stream().sorted(comparing(OrderBookItem::price).reversed()));
        String fullStringForChecksum = asksStringForChecksum + bidsStringForChecksum;
        CRC32 crc32 = new CRC32();
        crc32.update(fullStringForChecksum.getBytes());
        long localChecksum = crc32.getValue();
        return checksum.longValue() == localChecksum;
    }

    private String getStringForChecksum(Stream<OrderBookItem> items) {
        return items
                .map(o -> adaptForChecksumCalculation(o.priceStr()) + adaptForChecksumCalculation(o.volumeStr()))
                .collect(Collectors.joining());
    }

    private String adaptForChecksumCalculation(String original) {
        String withoutDecimal = original.replace(".", "");
        var firstNot0Character = Arrays.stream(withoutDecimal.split("")).filter(s -> !s.equals("0")).findFirst();
        return withoutDecimal.substring(withoutDecimal.indexOf(firstNot0Character.get()));
    }
}
