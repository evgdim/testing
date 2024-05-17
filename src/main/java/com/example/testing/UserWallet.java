package com.example.testing;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class UserWallet {
    private final Map<Symbol, BigDecimal> balances;

    public UserWallet(Map<Symbol, BigDecimal> balances) {
        this.balances = new HashMap<>(balances);
    }

    public BigDecimal getUserBalance(Symbol symbol) {
        BigDecimal balance = balances.get(symbol);
        if(balance != null) {
            return balance;
        } else return BigDecimal.ZERO;
    }

    public void setUserBalance(Symbol symbol, BigDecimal amount) {
        balances.put(symbol, amount);
    }
}
