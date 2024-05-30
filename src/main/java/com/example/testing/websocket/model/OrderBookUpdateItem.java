package com.example.testing.websocket.model;

import java.math.BigDecimal;

public record OrderBookUpdateItem(BigDecimal price, BigDecimal volume, BigDecimal timestamp) {
}
