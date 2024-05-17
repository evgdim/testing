package com.example.testing;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static com.example.testing.Symbol.BTC;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TradingClassTest {
    @Test
    public void testSuccessBuy() {
        HashMap<Symbol, BigDecimal> balances = new HashMap<>();
        balances.put(Symbol.USD, new BigDecimal(1000));
        ExchangeRate exchangeRate = mock(ExchangeRate.class);
        Trading trading = new Trading("user-123", balances, exchangeRate);

        Assertions.assertThat(trading.getUserBalance(Symbol.USD)).isEqualTo(new BigDecimal(1000));
        Assertions.assertThat(trading.getUserBalance(Symbol.BTC)).isEqualTo(BigDecimal.ZERO);

        when(exchangeRate.getExchangeRate(BTC)).thenReturn(new BigDecimal(900));
        Trade trade = trading.buy(BTC, 1);

        Assertions.assertThat(trade.getStatus()).isEqualTo(TradeStatus.SUCCESS);
        Assertions.assertThat(trading.getUserBalance(Symbol.USD)).isEqualTo(new BigDecimal(100));
        Assertions.assertThat(trading.getUserBalance(Symbol.BTC)).isEqualTo(BigDecimal.ONE);
    }
}
