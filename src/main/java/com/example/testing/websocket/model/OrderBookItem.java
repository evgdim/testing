package com.example.testing.websocket.model;

import java.math.BigDecimal;

public record OrderBookItem(BigDecimal price, String priceStr, BigDecimal volume, String volumeStr, BigDecimal timestamp) {
}
