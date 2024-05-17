package com.example.testing;

import java.math.BigDecimal;
import java.util.Map;

public class Trading {
    private final String userName;
    private final UserWallet wallet;
    private final ExchangeRate exchangeRate;
    public Trading(String userName, UserWallet wallet, ExchangeRate exchangeRate) {
        this.userName = userName;
        this.wallet = wallet;
        this.exchangeRate = exchangeRate;
    }

    public Trade buy(Symbol symbol, int amount) {
        BigDecimal buySymbolAmount = new BigDecimal(amount);
        if(amount <= 0) return new Trade(TradeStatus.FAILED, buySymbolAmount, symbol, "Invalid quantity");

        BigDecimal priceForOneUnit = exchangeRate.getExchangeRate(symbol);
        var amountPrice = priceForOneUnit.multiply(buySymbolAmount);

        BigDecimal usdBalance = wallet.getUserBalance(Symbol.USD);
        if(usdBalance.compareTo(amountPrice) >= 0 ) {
            BigDecimal balanceAfterTrade = wallet.getUserBalance(Symbol.USD).subtract(amountPrice);
            wallet.setUserBalance(Symbol.USD, balanceAfterTrade);
            wallet.setUserBalance(symbol, buySymbolAmount);
            return new Trade(TradeStatus.SUCCESS, amountPrice, symbol, null);
        } else {
            return new Trade(TradeStatus.FAILED, amountPrice, symbol, "Insufficient amount");
        }
    }


}
