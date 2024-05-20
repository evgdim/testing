package com.example.testing;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

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

    public void updateUserBalance(Symbol symbol, Function<BigDecimal, BigDecimal> updateBalance) {
        var currentBalance = balances.get(symbol);
        if(currentBalance == null) currentBalance = BigDecimal.ZERO;
        var newBalance = updateBalance.apply(currentBalance);
        balances.put(symbol, newBalance);
    }
}
