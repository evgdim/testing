package com.example.testing;

import java.math.BigDecimal;
import java.util.Optional;

public class Trade {
    private final TradeStatus status;
    private final BigDecimal amount;
    private final Symbol symbol;
    private final String errorMessage;

    public Trade(TradeStatus status, BigDecimal amount, Symbol symbol, String errorMessage) {
        this.status = status;
        this.amount = amount;
        this.symbol = symbol;
        this.errorMessage = errorMessage;
    }

    public TradeStatus getStatus() {
        return status;
    }

    public Optional<String> getMessage() {
        return Optional.ofNullable(errorMessage);
    }
}
