package com.example.testing;

import java.math.BigDecimal;
import java.util.Map;

public class Trading {
    private final String userName;
    private final Map<Symbol, BigDecimal> balances;
    private final ExchangeRate exchangeRate;
    public Trading(String userName, Map<Symbol, BigDecimal> balances, ExchangeRate exchangeRate) {
        this.userName = userName;
        this.balances = balances;
        this.exchangeRate = exchangeRate;
    }

    public Trade buy(Symbol symbol, int i) {
        BigDecimal priceForOneUnit = exchangeRate.getExchangeRate(symbol);
        BigDecimal buySymbolAmount = new BigDecimal(i);
        var amountPrice = priceForOneUnit.multiply(buySymbolAmount);
        BigDecimal usdBalance = balances.get(Symbol.USD);
        if(usdBalance.compareTo(amountPrice) >= 0 ) {
            BigDecimal balanceAfterTrade = balances.get(Symbol.USD).subtract(amountPrice);
            balances.put(Symbol.USD, balanceAfterTrade);
            balances.put(symbol, buySymbolAmount);
        } else throw new RuntimeException("Insufficient amount");
        return new Trade(TradeStatus.SUCCESS, amountPrice, symbol);
    }

    public BigDecimal getUserBalance(Symbol symbol) {
        BigDecimal balance = balances.get(symbol);
        if(balance != null) {
            return balance;
        } else return BigDecimal.ZERO;
    }
}
