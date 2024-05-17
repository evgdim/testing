package com.example.testing;

import java.math.BigDecimal;

public class Trade {
    private final TradeStatus status;
    private final BigDecimal amount;
    private final Symbol symbol;

    public Trade(TradeStatus status, BigDecimal amount, Symbol symbol) {
        this.status = status;
        this.amount = amount;
        this.symbol = symbol;
    }

    public TradeStatus getStatus() {
        return status;
    }
}
