package com.example.testing;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public class Exchange {
    private final Map<Symbol, BigDecimal> balances;

    public Exchange(Map<Symbol, BigDecimal> balances) {
        this.balances = balances;
    }

    public Optional<BigDecimal> getBalanace(Symbol symbol) {
        return Optional.ofNullable(balances.get(symbol));
    }
}
