package com.example.testing.websocket;

import com.example.testing.websocket.model.OrderBookItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.CRC32;

import static java.util.Comparator.*;

public class LocalOrderBook {
    private List<OrderBookItem> bids;
    private List<OrderBookItem> asks;

    public LocalOrderBook() {
        this.bids = new ArrayList<>();
        this.asks = new ArrayList<>();
    }

    synchronized public void update(List<OrderBookItem> updatedBids, List<OrderBookItem> updatedAsks, Long apiChecksum) {
        String asksStringForChecksum = calculateStringForChecksum(updatedAsks, this.asks, false);
        String bidsStringForChecksum = calculateStringForChecksum(updatedBids, this.bids, true);
        String fullStringForChecksum = asksStringForChecksum + bidsStringForChecksum;
        long localChecksum = calculateChecksum(fullStringForChecksum);
        System.out.println("local: "+localChecksum + " api: "+apiChecksum);
        if(apiChecksum != null && apiChecksum.longValue() != localChecksum) throw new InvalidChecksumException();
    }

    private String calculateStringForChecksum(List<OrderBookItem> updatedAsks, List<OrderBookItem> asks, boolean reversed) {
        String asksStringForChecksum;
        if (updatedAsks != null && !updatedAsks.isEmpty()) {
            upsertOrderBookItems(updatedAsks, asks);
            Stream<OrderBookItem> sortedAsks = getSortedOrderBookItems(asks, reversed).limit(10);
            asksStringForChecksum = getStringForChecksum(sortedAsks);
            asks = getSortedOrderBookItems(asks, reversed).limit(10).collect(Collectors.toList());
        } else {
            asksStringForChecksum = getStringForChecksum(getSortedOrderBookItems(asks, reversed));
        }
        return asksStringForChecksum;
    }

    private static long calculateChecksum(String value) {
        CRC32 crc32 = new CRC32();
        crc32.update(value.getBytes());
        return crc32.getValue();
    }

    private void upsertOrderBookItems(List<OrderBookItem> updateItems, List<OrderBookItem> localItems) {
        updateItems.forEach(iu -> {
            localItems.removeIf(i -> i.price().compareTo(iu.price()) == 0);
            localItems.add(iu);
        });
    }

    private static Stream<OrderBookItem> getSortedOrderBookItems(List<OrderBookItem> items, boolean reversed) {
        Comparator<OrderBookItem> comparing;
        if(reversed) {
            comparing = comparing(OrderBookItem::price).reversed();
        } else {
            comparing = comparing(OrderBookItem::price);
        }
        return items.stream().sorted(comparing);
    }

    private String getStringForChecksum(Stream<OrderBookItem> items) {
        return items
                .map(o -> adaptForChecksumCalculation(o.priceStr()) + adaptForChecksumCalculation(o.volumeStr()))
                .collect(Collectors.joining());
    }

    private String adaptForChecksumCalculation(String original) {
        String withoutDecimal = original.replace(".", "");
        var firstNot0Character = Arrays.stream(withoutDecimal.split("")).filter(s -> !s.equals("0")).findFirst();
        if(firstNot0Character.isEmpty()) return "";
        return withoutDecimal.substring(withoutDecimal.indexOf(firstNot0Character.get()));
    }
}
