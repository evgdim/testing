package com.example.testing;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;

public class Trading {
    private final String userName;
    private final UserWallet wallet;
    private final ExchangeRate exchangeRate;
    private final Exchange exchnage;
    public Trading(String userName, UserWallet wallet, ExchangeRate exchangeRate, Exchange exchnage) {
        this.userName = userName;
        this.wallet = wallet;
        this.exchangeRate = exchangeRate;
        this.exchnage = exchnage;
    }

    public Trade buy(Symbol symbol, int amount) {
        BigDecimal buySymbolAmount = new BigDecimal(amount);
        if(amount <= 0) return new Trade(TradeStatus.FAILED, buySymbolAmount, symbol, "Invalid quantity");

        BigDecimal priceForOneUnit = exchangeRate.getExchangeRate(symbol);
        var amountPrice = priceForOneUnit.multiply(buySymbolAmount);

        BigDecimal usdBalance = wallet.getUserBalance(Symbol.USD);
        boolean hasSufficientUserBalance = usdBalance.compareTo(amountPrice) >= 0;
        Optional<BigDecimal> exchangeBalanace = exchnage.getBalanace(symbol);
        boolean hasSufficientExchangeBalance = exchangeBalanace.isPresent() && exchangeBalanace.get().compareTo(buySymbolAmount) > 0;
        if(hasSufficientUserBalance && hasSufficientExchangeBalance) {
            wallet.updateUserBalance(Symbol.USD, currentBalance -> currentBalance.subtract(amountPrice));
            wallet.updateUserBalance(symbol, currentBalance -> currentBalance.add(buySymbolAmount));
            return new Trade(TradeStatus.SUCCESS, amountPrice, symbol, null);
        } else {
            if(!hasSufficientUserBalance) return new Trade(TradeStatus.FAILED, amountPrice, symbol, "Insufficient user balance");
            if(!hasSufficientExchangeBalance) return new Trade(TradeStatus.FAILED, amountPrice, symbol, "Insufficient exchange balance");
            throw new RuntimeException("All conditions met, bu trade failed");
        }
    }


}
