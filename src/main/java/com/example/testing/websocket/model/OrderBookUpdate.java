package com.example.testing.websocket.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderBookUpdate {
    private final List<OrderBookItem> bids;
    private final List<OrderBookItem> asks;
    private final String channelName;
    private final String pair;
    private final Long checksum;

    @JsonCreator
    public OrderBookUpdate(List<Object> items) {
        //Long id = (Long)items.get(0); not needed
        this.checksum = getChecksum((Map<String, Object>) items.get(1));
        Map<String, ArrayList<ArrayList<String>>> asksBidsMap = (Map<String, ArrayList<ArrayList<String>>>)items.get(1);
        if(this.checksum != null) { // update
            ArrayList<ArrayList<String>> b = asksBidsMap.get("b");
            if(b != null) bids = mapItems(b); else bids = List.of();
            ArrayList<ArrayList<String>> a = asksBidsMap.get("a");
            if(a != null) asks = mapItems(a); else asks = List.of();
        } else { // full book
            ArrayList<ArrayList<String>> bs = asksBidsMap.get("bs");
            if(bs != null) bids = mapItems(bs); else bids = List.of();
            ArrayList<ArrayList<String>> as = asksBidsMap.get("as");
            if(as != null) asks = mapItems(as); else asks = List.of();
        }
        this.channelName = (String) items.get(2);
        this.pair = (String) items.get(3);
    }

    private static Long getChecksum(Map<String, Object> items) {
        String c = (String) items.get("c");
        if(c == null) return null;
        return Long.parseLong(c);
    }

    private static List<OrderBookItem> mapItems(ArrayList<ArrayList<String>> items) {
        return items.stream()
                .map(i -> {
                    String priceStr = i.get(0);
                    String volumeStr = i.get(1);
                    String timestamp = i.get(2);
                    String republished = null;
                    if(i.size() == 4) republished = i.get(3);
                    return new OrderBookItem(
                                                new BigDecimal(priceStr),
                                                priceStr,
                                                new BigDecimal(volumeStr),
                                                volumeStr,
                                                new BigDecimal(timestamp),
                                                "r".equals(republished)
                                    );
                        }
                ).collect(Collectors.toList());
    }

    public String getChannelName() {
        return channelName;
    }

    public String getPair() {
        return pair;
    }

    public Long getChecksum() {
        return checksum;
    }

    public List<OrderBookItem> getBids() {
        return bids;
    }

    public List<OrderBookItem> getAsks() {
        return asks;
    }


    @Override
    public String toString() {
        return "OrderBookUpdate{" +
                "bids=" + bids +
                ", asks=" + asks +
                ", channelName='" + channelName + '\'' +
                ", pair='" + pair + '\'' +
                ", checksum=" + checksum +
                '}';
    }
}