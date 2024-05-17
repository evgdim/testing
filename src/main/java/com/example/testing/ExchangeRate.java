package com.example.testing;

import java.math.BigDecimal;

public class ExchangeRate {
    public BigDecimal getExchangeRate(Symbol symbol) {
        return switch (symbol) {
            case BTC -> new BigDecimal(900);
            default -> throw new RuntimeException("Invalid symbol");
        };
    }
}
