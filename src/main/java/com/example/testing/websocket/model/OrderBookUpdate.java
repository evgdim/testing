package com.example.testing.websocket.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderBookUpdate {
    private final List<OrderBookUpdateItem> bids;
    private final List<OrderBookUpdateItem> asks;
    private final String channelName;
    private final String pair;
    private final Long checksum;

    @JsonCreator
    public OrderBookUpdate(List<Object> items) {
        //Long id = (Long)items.get(0); not needed
        if(items.size() > 4) this.checksum = (Long)items.get(4); else checksum = null;
        Map<String, ArrayList<ArrayList<String>>> asksBidsMap = (Map<String, ArrayList<ArrayList<String>>>)items.get(1);
        if(this.checksum != null) { // update
            bids = mapItems(asksBidsMap.get("b"));
            asks = mapItems(asksBidsMap.get("a"));
        } else { // full book
            bids = mapItems(asksBidsMap.get("bs"));
            asks = mapItems(asksBidsMap.get("as"));
        }
        this.channelName = (String) items.get(2);
        this.pair = (String) items.get(3);
    }

    private static List<OrderBookUpdateItem> mapItems(ArrayList<ArrayList<String>> items) {
        return items.stream()
                .map(i -> new OrderBookUpdateItem(
                                    new BigDecimal(i.get(0)),
                                    new BigDecimal(i.get(1)),
                                    new BigDecimal(i.get(2))
                        )
                ).toList();
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

    @Override
    public String toString() {
        return "TestJsonCreator{" +
                "bids=" + bids +
                ", asks=" + asks +
                ", channelName='" + channelName + '\'' +
                ", pair='" + pair + '\'' +
                ", checksum=" + checksum +
                '}';
    }
}