package com.example.testing.websocket;

import com.example.testing.websocket.model.OrderBookItem;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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
        List<OrderBookItem> bids = List.of(
            new OrderBookItem(new BigDecimal("0.05000"),"0.05000",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905487.439814")),
            new OrderBookItem(new BigDecimal("0.04995"),"0.04995",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905485.119396")),
            new OrderBookItem(new BigDecimal("0.04990"),"0.04990",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905486.432052")),
            new OrderBookItem(new BigDecimal("0.04980"),"0.04980",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905480.609351")),
            new OrderBookItem(new BigDecimal("0.04975"),"0.04975",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905476.793880")),
            new OrderBookItem(new BigDecimal("0.04970"),"0.04970",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905486.767461")),
            new OrderBookItem(new BigDecimal("0.04965"),"0.04965",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905481.767528")),
            new OrderBookItem(new BigDecimal("0.04960"),"0.04960",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905487.378907")),
            new OrderBookItem(new BigDecimal("0.04955"),"0.04955",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905483.626664")),
            new OrderBookItem(new BigDecimal("0.04950"),"0.04950",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905488.509872"))
        );
        //https://docs.kraken.com/websockets/

        localOrderBook.update(bids, asks,  974947235L);
    }

    @Test
    public void tetUpdate() {
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
        List<OrderBookItem> bids = List.of(
                new OrderBookItem(new BigDecimal("0.05000"),"0.05000",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905487.439814")),
                new OrderBookItem(new BigDecimal("0.04995"),"0.04995",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905485.119396")),
                new OrderBookItem(new BigDecimal("0.04990"),"0.04990",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905486.432052")),
                new OrderBookItem(new BigDecimal("0.04980"),"0.04980",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905480.609351")),
                new OrderBookItem(new BigDecimal("0.04975"),"0.04975",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905476.793880")),
                new OrderBookItem(new BigDecimal("0.04970"),"0.04970",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905486.767461")),
                new OrderBookItem(new BigDecimal("0.04965"),"0.04965",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905481.767528")),
                new OrderBookItem(new BigDecimal("0.04960"),"0.04960",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905487.378907")),
                new OrderBookItem(new BigDecimal("0.04955"),"0.04955",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905483.626664")),
                new OrderBookItem(new BigDecimal("0.04950"),"0.04950",new BigDecimal("0.00000500"),"0.00000500", new BigDecimal("1582905488.509872"))
        );

        LocalOrderBook localOrderBook = new LocalOrderBook();
        localOrderBook.update(bids, asks, 974947235L);

        Assertions.assertThrows(InvalidChecksumException.class, () -> {
            localOrderBook.update(List.of(), List.of(
                            new OrderBookItem(new BigDecimal("0.05010"), "0.05010", new BigDecimal("0.00000510"), "0.00000510", new BigDecimal("1582905486.187983"))),
                    974947235L);
        });
    }

    @Test
    public void tetUpdate2() {
        var asks = List.of(
                new OrderBookItem(new BigDecimal("58226.70000"),"58226.70000",new BigDecimal("12.92016371"),"12.92016371", new BigDecimal("1582905487.684110")),
                new OrderBookItem(new BigDecimal("58228.90000"),"58228.90000",new BigDecimal("0.16870000"), "0.16870000", new BigDecimal("1582905486.187983")),
                new OrderBookItem(new BigDecimal("58234.10000"),"58234.10000",new BigDecimal("0.99992060"), "0.99992060", new BigDecimal("1582905484.480241")),
                new OrderBookItem(new BigDecimal("58241.30000"),"58241.30000",new BigDecimal("0.53840000"), "0.53840000", new BigDecimal("1582905486.645658")),
                new OrderBookItem(new BigDecimal("58243.00000"),"58243.00000",new BigDecimal("0.16870000"), "0.16870000", new BigDecimal("1582905486.859009")),
                new OrderBookItem(new BigDecimal("58247.50000"),"58247.50000",new BigDecimal("0.83360002"), "0.83360002", new BigDecimal("1582905488.601486")),
                new OrderBookItem(new BigDecimal("58247.60000"),"58247.60000",new BigDecimal("0.09400000"), "0.09400000", new BigDecimal("1582905488.357312")),
                new OrderBookItem(new BigDecimal("58247.70000"),"58247.70000",new BigDecimal("0.42000000"), "0.42000000", new BigDecimal("1582905488.785484")),
                new OrderBookItem(new BigDecimal("58250.00000"),"58250.00000",new BigDecimal("0.26744346"), "0.26744346", new BigDecimal("1582905485.302661")),
                new OrderBookItem(new BigDecimal("58250.10000"),"58250.10000",new BigDecimal("0.04454749"), "0.04454749", new BigDecimal("1582905486.157467"))
        );
        List<OrderBookItem> bids = List.of(
                new OrderBookItem(new BigDecimal("58226.60000"),"58226.60000",new BigDecimal("0.00100000"), "0.00100000", new BigDecimal("1723468718.626932")),
                new OrderBookItem(new BigDecimal("58210.10000"),"58210.10000",new BigDecimal("1.00000000"), "1.00000000", new BigDecimal("1723468727.406247")),
                new OrderBookItem(new BigDecimal("58203.00000"),"58203.00000",new BigDecimal("0.16870000"), "0.16870000", new BigDecimal("1723468729.580852")),
                new OrderBookItem(new BigDecimal("58200.90000"),"58200.90000",new BigDecimal("0.51532933"), "0.51532933", new BigDecimal("1723468730.112696")),
                new OrderBookItem(new BigDecimal("58200.80000"),"58200.80000",new BigDecimal("0.73398456"), "0.73398456", new BigDecimal("1723468727.579553")),
                new OrderBookItem(new BigDecimal("58195.10000"),"58195.10000",new BigDecimal("0.49917012"), "0.49917012", new BigDecimal("1723468702.061395")),
                new OrderBookItem(new BigDecimal("58194.90000"),"58194.90000",new BigDecimal("0.16870000"), "0.16870000", new BigDecimal("1723468728.830693")),
                new OrderBookItem(new BigDecimal("58193.80000"),"58193.80000",new BigDecimal("0.51521339"), "0.51521339", new BigDecimal("1723468727.507412")),
                new OrderBookItem(new BigDecimal("58192.70000"),"58192.70000",new BigDecimal("0.51537600"), "0.51537600", new BigDecimal("1723468724.525164")),
                new OrderBookItem(new BigDecimal("58192.60000"),"58192.60000",new BigDecimal("0.51521339"), "0.51521339", new BigDecimal("1723468690.954070"))
        );

        LocalOrderBook localOrderBook = new LocalOrderBook();
        localOrderBook.update(bids, asks, null);

        localOrderBook.update(List.of(),
                List.of(
                        new OrderBookItem(new BigDecimal("58226.70000"), "58226.70000", new BigDecimal("13.08886371"), "13.08886371", new BigDecimal("1582905486.187983"))
                ),
                2195388083L);

    }

    @Test
    public void tetUpdate3() {
        var asks = List.of(
                new OrderBookItem(new BigDecimal("60052.50000"),"60052.50000",new BigDecimal("0.00190000"), "0.00190000", new BigDecimal("1582905487.684110")),
                new OrderBookItem(new BigDecimal("60064.00000"),"60064.00000",new BigDecimal("1.00000000"), "1.00000000", new BigDecimal("1582905486.187983")),
                new OrderBookItem(new BigDecimal("60064.70000"),"60064.70000",new BigDecimal("0.16870000"), "0.16870000", new BigDecimal("1582905484.480241")),
                new OrderBookItem(new BigDecimal("60072.20000"),"60072.20000",new BigDecimal("0.16870000"), "0.16870000", new BigDecimal("1582905486.645658")),
                new OrderBookItem(new BigDecimal("60083.00000"),"60083.00000",new BigDecimal("0.16870000"), "0.16870000", new BigDecimal("1582905486.859009")),
                new OrderBookItem(new BigDecimal("60084.90000"),"60084.90000",new BigDecimal("0.49970700"), "0.49970700", new BigDecimal("1582905488.601486")),
                new OrderBookItem(new BigDecimal("60088.80000"),"60088.80000",new BigDecimal("0.00455780"), "0.00455780", new BigDecimal("1582905488.357312")),
                new OrderBookItem(new BigDecimal("60088.90000"),"60088.90000",new BigDecimal("4.16050281"), "4.16050281", new BigDecimal("1582905488.785484")),
                new OrderBookItem(new BigDecimal("60089.30000"),"60089.30000",new BigDecimal("0.83360002"), "0.83360002", new BigDecimal("1582905485.302661")),
                new OrderBookItem(new BigDecimal("60089.50000"),"60089.50000",new BigDecimal("0.06564492"), "0.06564492", new BigDecimal("1582905486.157467"))
        );
        List<OrderBookItem> bids = List.of(
                new OrderBookItem(new BigDecimal("60034.30000"),"60034.30000",new BigDecimal("0.10000000"), "0.10000000", new BigDecimal("1723468718.626932")),
                new OrderBookItem(new BigDecimal("60034.20000"),"60034.20000",new BigDecimal("0.52830000"), "0.52830000", new BigDecimal("1723468727.406247")),
                new OrderBookItem(new BigDecimal("60033.60000"),"60033.60000",new BigDecimal("0.16870000"), "0.16870000", new BigDecimal("1723468729.580852")),
                new OrderBookItem(new BigDecimal("60032.10000"),"60032.10000",new BigDecimal("0.83913480"), "0.83913480", new BigDecimal("1723468730.112696")),
                new OrderBookItem(new BigDecimal("60032.00000"),"60032.00000",new BigDecimal("0.16870000"), "0.16870000", new BigDecimal("1723468727.579553")),
                new OrderBookItem(new BigDecimal("60027.80000"),"60027.80000",new BigDecimal("0.33400000"), "0.33400000", new BigDecimal("1723468702.061395")),
                new OrderBookItem(new BigDecimal("60024.10000"),"60024.10000",new BigDecimal("0.16870000"), "0.16870000", new BigDecimal("1723468728.830693")),
                new OrderBookItem(new BigDecimal("60021.10000"),"60021.10000",new BigDecimal("0.10000000"), "0.10000000", new BigDecimal("1723468727.507412")),
                new OrderBookItem(new BigDecimal("60017.90000"),"60017.90000",new BigDecimal("0.00100000"), "0.00100000", new BigDecimal("1723468724.525164")),
                new OrderBookItem(new BigDecimal("60017.30000"),"60017.30000",new BigDecimal("0.00100000"), "0.00100000", new BigDecimal("1723468690.954070"))
        );

        LocalOrderBook localOrderBook = new LocalOrderBook();
        localOrderBook.update(bids, asks, null);

        localOrderBook.update(List.of(
                        new OrderBookItem(new BigDecimal("60034.30000"), "60034.30000", new BigDecimal("0.00000000"), "0.00000000", new BigDecimal("1582905486.187983")),
                        new OrderBookItem(new BigDecimal("60015.90000"), "60015.90000", new BigDecimal("0.16870000"), "0.16870000", new BigDecimal("1582905486.187983"))
                ),
                List.of(),
                2569088362L);

    }
}
