package com.example.testing;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import static com.example.testing.Symbol.BTC;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TradingClassTest {
    private UserWallet wallet;
    private ExchangeRate exchangeRateMock;
    private Exchange exchangeMock;
    private Trading trading;

    private void init(BigDecimal startingUserBalance) {
        wallet = new UserWallet(Map.of(Symbol.USD, startingUserBalance));
        exchangeRateMock = mock(ExchangeRate.class);
        exchangeMock = mock(Exchange.class);
        trading = new Trading(wallet, exchangeRateMock, exchangeMock);
    }
    @Test
    public void testSuccessBuy() {
        init(new BigDecimal(1000));

        Assertions.assertThat(wallet.getUserBalance(Symbol.USD)).isEqualTo(new BigDecimal(1000));
        Assertions.assertThat(wallet.getUserBalance(Symbol.BTC)).isEqualTo(BigDecimal.ZERO);

        when(exchangeRateMock.getExchangeRate(BTC)).thenReturn(new BigDecimal(900));
        when(exchangeMock.getBalanace(any())).thenReturn(Optional.of(new BigDecimal(10)));

        Trade trade = trading.buy(BTC, 1);

        Assertions.assertThat(trade.getStatus()).isEqualTo(TradeStatus.SUCCESS);
        Assertions.assertThat(wallet.getUserBalance(Symbol.USD)).isEqualTo(new BigDecimal(100));
        Assertions.assertThat(wallet.getUserBalance(Symbol.BTC)).isEqualTo(BigDecimal.ONE);
    }

    @Test
    public void testFailedBuy() {
        init(new BigDecimal(1000));
        when(exchangeRateMock.getExchangeRate(BTC)).thenReturn(new BigDecimal(900));
        when(exchangeMock.getBalanace(any())).thenReturn(Optional.of(new BigDecimal(10)));

        Trade trade = trading.buy(BTC, 2);

        Assertions.assertThat(trade.getStatus()).isEqualTo(TradeStatus.FAILED);
        Assertions.assertThat(trade.getMessage()).isEqualTo(Optional.of("Insufficient user balance"));
        Assertions.assertThat(wallet.getUserBalance(Symbol.USD)).isEqualTo(new BigDecimal(1000));
        Assertions.assertThat(wallet.getUserBalance(Symbol.BTC)).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void testFailedBuyInvalidAmount() {
        init(new BigDecimal(1000));
        when(exchangeRateMock.getExchangeRate(BTC)).thenReturn(new BigDecimal(900));
        when(exchangeMock.getBalanace(any())).thenReturn(Optional.of(new BigDecimal(10)));

        Trade trade1 = trading.buy(BTC, 0);

        Assertions.assertThat(trade1.getStatus()).isEqualTo(TradeStatus.FAILED);
        Assertions.assertThat(trade1.getMessage().get()).isEqualTo("Invalid quantity");

        Trade trade2 = trading.buy(BTC, -1);

        Assertions.assertThat(trade2.getStatus()).isEqualTo(TradeStatus.FAILED);
        Assertions.assertThat(trade2.getMessage().get()).isEqualTo("Invalid quantity");
    }

    @Test
    public void testExchnageInsufficientFunds() {
        init(new BigDecimal(999999999999999999L));
        when(exchangeRateMock.getExchangeRate(BTC)).thenReturn(new BigDecimal(900));
        when(exchangeMock.getBalanace(any())).thenReturn(Optional.of(new BigDecimal(10)));

        Trade trade = trading.buy(BTC, 1000);

        Assertions.assertThat(trade.getStatus()).isEqualTo(TradeStatus.FAILED);
        Assertions.assertThat(trade.getMessage()).isEqualTo(Optional.of("Insufficient exchange balance"));
    }
}
