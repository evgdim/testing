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
    public void testUpdate() {
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
    public void testUpdate2() {
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
    public void testUpdateWith0Volume() {
        var bids = List.of(
                new OrderBookItem(new BigDecimal("68150.00000"), "68150.00000", new BigDecimal("0.36481843"), "0.36481843", new BigDecimal("1729078521.619943")),
                new OrderBookItem(new BigDecimal("68146.10000"), "68146.10000", new BigDecimal("0.00375742"), "0.00375742", new BigDecimal("1729078519.068319")),
                new OrderBookItem(new BigDecimal("68143.30000"), "68143.30000", new BigDecimal("3.66873703"), "3.66873703", new BigDecimal("1729078521.732722")),
                new OrderBookItem(new BigDecimal("68140.30000"), "68140.30000", new BigDecimal("0.04747357"), "0.04747357", new BigDecimal("1729078521.341279")),
                new OrderBookItem(new BigDecimal("68139.70000"), "68139.70000", new BigDecimal("0.00014684"), "0.00014684", new BigDecimal("1729078512.079461")),
                new OrderBookItem(new BigDecimal("68139.50000"), "68139.50000", new BigDecimal("3.66893881"), "3.66893881", new BigDecimal("1729078521.732517")),
                new OrderBookItem(new BigDecimal("68136.30000"), "68136.30000", new BigDecimal("0.00014684"), "0.00014684", new BigDecimal("1729078438.471464")),
                new OrderBookItem(new BigDecimal("68135.50000"), "68135.50000", new BigDecimal("7.33831223"), "7.33831223", new BigDecimal("1729078516.007905")),
                new OrderBookItem(new BigDecimal("68135.30000"), "68135.30000", new BigDecimal("0.01466984"), "0.01466984", new BigDecimal("1729078521.568741")),
                new OrderBookItem(new BigDecimal("68133.80000"), "68133.80000", new BigDecimal("0.04454749"), "0.04454749", new BigDecimal("1729078505.706169")),
                new OrderBookItem(new BigDecimal("68133.00000"), "68133.00000", new BigDecimal("0.32440912"), "0.32440912", new BigDecimal("1729078513.043816")),
                new OrderBookItem(new BigDecimal("68132.90000"), "68132.90000", new BigDecimal("0.00014684"), "0.00014684", new BigDecimal("1729078519.666788")),
                new OrderBookItem(new BigDecimal("68132.50000"), "68132.50000", new BigDecimal("0.63223838"), "0.63223838", new BigDecimal("1729078520.703249")),
                new OrderBookItem(new BigDecimal("68129.50000"), "68129.50000", new BigDecimal("0.00014684"), "0.00014684", new BigDecimal("1729078508.818691")),
                new OrderBookItem(new BigDecimal("68126.70000"), "68126.70000", new BigDecimal("0.03081639"), "0.03081639", new BigDecimal("1729078505.616761")),
                new OrderBookItem(new BigDecimal("68126.60000"), "68126.60000", new BigDecimal("0.01100000"), "0.01100000", new BigDecimal("1729078465.130094")),
                new OrderBookItem(new BigDecimal("68126.10000"), "68126.10000", new BigDecimal("0.00014684"), "0.00014684", new BigDecimal("1729078441.420744")),
                new OrderBookItem(new BigDecimal("68123.90000"), "68123.90000", new BigDecimal("0.37120000"), "0.37120000", new BigDecimal("1729078511.518314")),
                new OrderBookItem(new BigDecimal("68122.70000"), "68122.70000", new BigDecimal("0.43828721"), "0.43828721", new BigDecimal("1729078513.076036")),
                new OrderBookItem(new BigDecimal("68122.60000"), "68122.60000", new BigDecimal("0.00014684"), "0.00014684", new BigDecimal("1729078260.899072")),
                new OrderBookItem(new BigDecimal("68121.70000"), "68121.70000", new BigDecimal("7.33979689"), "7.33979689", new BigDecimal("1729078518.720585")),
                new OrderBookItem(new BigDecimal("68121.60000"), "68121.60000", new BigDecimal("7.33981559"), "7.33981559", new BigDecimal("1729078519.540447")),
                new OrderBookItem(new BigDecimal("68119.20000"), "68119.20000", new BigDecimal("0.00014684"), "0.00014684", new BigDecimal("1729078490.419119")),
                new OrderBookItem(new BigDecimal("68118.90000"), "68118.90000", new BigDecimal("0.25000000"), "0.25000000", new BigDecimal("1729078513.385788")),
                new OrderBookItem(new BigDecimal("68118.30000"), "68118.30000", new BigDecimal("0.02296543"), "0.02296543", new BigDecimal("1729078506.337320"))
        );
        List<OrderBookItem> asks = List.of(
                new OrderBookItem(new BigDecimal("68150.10000"), "68150.10000", new BigDecimal("7.84449223"), "7.84449223", new BigDecimal("1729078520.864418")),
                new OrderBookItem(new BigDecimal("68150.80000"), "68150.80000", new BigDecimal("3.66834079"), "3.66834079", new BigDecimal("1729078519.640187")),
                new OrderBookItem(new BigDecimal("68151.60000"), "68151.60000", new BigDecimal("0.80380843"), "0.80380843", new BigDecimal("1729078515.020793")),
                new OrderBookItem(new BigDecimal("68153.10000"), "68153.10000", new BigDecimal("3.66821462"), "3.66821462", new BigDecimal("1729078519.982236")),
                new OrderBookItem(new BigDecimal("68155.40000"), "68155.40000", new BigDecimal("1.35222757"), "1.35222757", new BigDecimal("1729078506.386595")),
                new OrderBookItem(new BigDecimal("68155.70000"), "68155.70000", new BigDecimal("7.33615044"), "7.33615044", new BigDecimal("1729078519.982332")),
                new OrderBookItem(new BigDecimal("68158.80000"), "68158.80000", new BigDecimal("0.37120000"), "0.37120000", new BigDecimal("1729078513.330874")),
                new OrderBookItem(new BigDecimal("68160.90000"), "68160.90000", new BigDecimal("0.31611919"), "0.31611919", new BigDecimal("1729078520.780048")),
                new OrderBookItem(new BigDecimal("68165.10000"), "68165.10000", new BigDecimal("0.61589000"), "0.61589000", new BigDecimal("1729078503.502889")),
                new OrderBookItem(new BigDecimal("68165.70000"), "68165.70000", new BigDecimal("0.37163689"), "0.37163689", new BigDecimal("1729078519.560235")),
                new OrderBookItem(new BigDecimal("68166.30000"), "68166.30000", new BigDecimal("0.02684538"), "0.02684538", new BigDecimal("1729078511.617123")),
                new OrderBookItem(new BigDecimal("68166.70000"), "68166.70000", new BigDecimal("7.33496351"), "7.33496351", new BigDecimal("1729078506.453450")),
                new OrderBookItem(new BigDecimal("68168.50000"), "68168.50000", new BigDecimal("0.29290000"), "0.29290000", new BigDecimal("1729078506.954696")),
                new OrderBookItem(new BigDecimal("68177.20000"), "68177.20000", new BigDecimal("0.37120000"), "0.37120000", new BigDecimal("1729078500.662833")),
                new OrderBookItem(new BigDecimal("68177.60000"), "68177.60000", new BigDecimal("0.01532212"), "0.01532212", new BigDecimal("1729078520.495748")),
                new OrderBookItem(new BigDecimal("68177.80000"), "68177.80000", new BigDecimal("0.29454749"), "0.29454749", new BigDecimal("1729078505.791362")),
                new OrderBookItem(new BigDecimal("68178.10000"), "68178.10000", new BigDecimal("1.86402627"), "1.86402627", new BigDecimal("1729078519.859203")),
                new OrderBookItem(new BigDecimal("68178.20000"), "68178.20000", new BigDecimal("7.33373288"), "7.33373288", new BigDecimal("1729078513.096091")),
                new OrderBookItem(new BigDecimal("68180.00000"), "68180.00000", new BigDecimal("0.27834760"), "0.27834760", new BigDecimal("1729078506.947424")),
                new OrderBookItem(new BigDecimal("68180.10000"), "68180.10000", new BigDecimal("0.03394000"), "0.03394000", new BigDecimal("1729078505.312906")),
                new OrderBookItem(new BigDecimal("68182.40000"), "68182.40000", new BigDecimal("0.85328774"), "0.85328774", new BigDecimal("1729078507.124005")),
                new OrderBookItem(new BigDecimal("68185.40000"), "68185.40000", new BigDecimal("0.00318972"), "0.00318972", new BigDecimal("1729078503.309921")),
                new OrderBookItem(new BigDecimal("68185.50000"), "68185.50000", new BigDecimal("2.39380832"), "2.39380832", new BigDecimal("1729078519.859168")),
                new OrderBookItem(new BigDecimal("68185.60000"), "68185.60000", new BigDecimal("3.66646769"), "3.66646769", new BigDecimal("1729078506.263258")),
                new OrderBookItem(new BigDecimal("68187.50000"), "68187.50000", new BigDecimal("0.37120000"), "0.37120000", new BigDecimal("1729078493.811483"))
        );

        //local cs 4216331490

        LocalOrderBook localOrderBook = new LocalOrderBook();
        localOrderBook.update(bids, asks, null);

        localOrderBook.update(List.of(
                        new OrderBookItem(new BigDecimal("68143.30000"), "68143.30000", new BigDecimal("0")         , "0.00000000", new BigDecimal("1729078521.841720"), false),
                        new OrderBookItem(new BigDecimal("68118.00000"), "68118.00000", new BigDecimal("0.03390000"), "0.03390000", new BigDecimal("1729078519.658733"), true)
                ),
                List.of(),
                4043596651L);

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
