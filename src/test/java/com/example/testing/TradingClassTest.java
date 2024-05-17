package com.example.testing;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import static com.example.testing.Symbol.BTC;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TradingClassTest {
    @Test
    public void testSuccessBuy() {
        UserWallet wallet = new UserWallet(Map.of(Symbol.USD, new BigDecimal(1000)));
        ExchangeRate exchangeRate = mock(ExchangeRate.class);
        Trading trading = new Trading("user-123", wallet, exchangeRate);

        Assertions.assertThat(wallet.getUserBalance(Symbol.USD)).isEqualTo(new BigDecimal(1000));
        Assertions.assertThat(wallet.getUserBalance(Symbol.BTC)).isEqualTo(BigDecimal.ZERO);

        when(exchangeRate.getExchangeRate(BTC)).thenReturn(new BigDecimal(900));
        Trade trade = trading.buy(BTC, 1);

        Assertions.assertThat(trade.getStatus()).isEqualTo(TradeStatus.SUCCESS);
        Assertions.assertThat(wallet.getUserBalance(Symbol.USD)).isEqualTo(new BigDecimal(100));
        Assertions.assertThat(wallet.getUserBalance(Symbol.BTC)).isEqualTo(BigDecimal.ONE);
    }

    @Test
    public void testFailedBuy() {
        UserWallet wallet = new UserWallet(Map.of(Symbol.USD, new BigDecimal(1000)));
        ExchangeRate exchangeRate = mock(ExchangeRate.class);
        Trading trading = new Trading("user-123", wallet, exchangeRate);

        when(exchangeRate.getExchangeRate(BTC)).thenReturn(new BigDecimal(900));
        Trade trade = trading.buy(BTC, 2);

        Assertions.assertThat(trade.getStatus()).isEqualTo(TradeStatus.FAILED);
        Assertions.assertThat(trade.getMessage()).isEqualTo(Optional.of("Insufficient amount"));
        Assertions.assertThat(wallet.getUserBalance(Symbol.USD)).isEqualTo(new BigDecimal(1000));
        Assertions.assertThat(wallet.getUserBalance(Symbol.BTC)).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void testFailedBuyInvalidAmount() {
        UserWallet wallet = new UserWallet(Map.of(Symbol.USD, new BigDecimal(1000)));
        ExchangeRate exchangeRate = mock(ExchangeRate.class);
        when(exchangeRate.getExchangeRate(BTC)).thenReturn(new BigDecimal(900));
        Trading trading = new Trading("user-123", wallet, exchangeRate);

        Trade trade1 = trading.buy(BTC, 0);

        Assertions.assertThat(trade1.getStatus()).isEqualTo(TradeStatus.FAILED);
        Assertions.assertThat(trade1.getMessage().get()).isEqualTo("Invalid quantity");

        Trade trade2 = trading.buy(BTC, -1);
        Assertions.assertThat(trade2.getStatus()).isEqualTo(TradeStatus.FAILED);
        Assertions.assertThat(trade2.getMessage().get()).isEqualTo("Invalid quantity");
    }
}
