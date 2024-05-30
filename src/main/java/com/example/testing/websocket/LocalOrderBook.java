package com.example.testing.websocket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LocalOrderBook {
    private final List<BigDecimal> bids;
    private final List<BigDecimal> asks;

    public LocalOrderBook() {
        this.bids = new ArrayList<>();
        this.asks = new ArrayList<>();
    }


}
