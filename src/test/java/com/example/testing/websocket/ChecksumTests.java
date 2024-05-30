package com.example.testing.websocket;

import com.example.testing.websocket.model.OrderBookItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class ChecksumTests {
    @Test
    public  void checksum() {
        LocalOrderBook localOrderBook = new LocalOrderBook();
        var asks = List.of(
        new OrderBookItem(new BigDecimal("0.05005"),"0.05005",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905487.684110")),
        new OrderBookItem(new BigDecimal("0.05010"),"0.05010",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905486.187983")),
        new OrderBookItem(new BigDecimal("0.05015"),"0.05015",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905484.480241")),
        new OrderBookItem(new BigDecimal("0.05020"),"0.05020",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905486.645658")),
        new OrderBookItem(new BigDecimal("0.05025"),"0.05025",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905486.859009")),
        new OrderBookItem(new BigDecimal("0.05030"),"0.05030",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905488.601486")),
        new OrderBookItem(new BigDecimal("0.05035"),"0.05035",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905488.357312")),
        new OrderBookItem(new BigDecimal("0.05040"),"0.05040",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905488.785484")),
        new OrderBookItem(new BigDecimal("0.05045"),"0.05045",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905485.302661")),
        new OrderBookItem(new BigDecimal("0.05050"),"0.05050",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905486.157467"))
        );
        List<OrderBookItem> bids = List.of();
        //https://docs.kraken.com/websockets/
//        [ "0.05000", "0.00000500", "1582905487.439814" ],
//    [ "0.04995", "0.00000500", "1582905485.119396" ],
//    [ "0.04990", "0.00000500", "1582905486.432052" ],
//    [ "0.04980", "0.00000500", "1582905480.609351" ],
//    [ "0.04975", "0.00000500", "1582905476.793880" ],
//    [ "0.04970", "0.00000500", "1582905486.767461" ],
//    [ "0.04965", "0.00000500", "1582905481.767528" ],
//    [ "0.04960", "0.00000500", "1582905487.378907" ],
//    [ "0.04955", "0.00000500", "1582905483.626664" ],
//    [ "0.04950", "0.00000500", "1582905488.509872" ]
        localOrderBook.update(bids, asks,  974947235L);
    }
}
