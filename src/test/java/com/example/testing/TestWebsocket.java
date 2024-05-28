package com.example.testing;

import com.example.testing.websocket.KrakenClient;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import reactor.test.StepVerifier;

import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestWebsocket {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        KrakenClient krakenClientMock = mock(KrakenClient.class);
        doAnswer(invocationOnMock -> {
            ((Consumer<String>) invocationOnMock.getArguments()[0]).accept("Test response");
            return null;
        }).when(krakenClientMock).listenOrderBookUpdates(any());

        krakenClientMock.listenOrderBookUpdates(new Consumer<String>() {
            @Override
            public void accept(String s) {
                assertThat(s).isEqualTo("Test response");
            }
        });
    }

    @Test
    public void testFlux() throws ExecutionException, InterruptedException {
        KrakenClient krakenClientMock = spy(KrakenClient.class);
        doAnswer(invocationOnMock -> {
            ((Consumer<String>) invocationOnMock.getArguments()[0]).accept("Test response");
            return null;
        }).when(krakenClientMock).listenOrderBookUpdates(any());

        var orderBook = krakenClientMock.orderBookUpdates();
                //.subscribe(s -> assertThat(s).isEqualTo("Test response"));

        StepVerifier
                .create(orderBook)
                .expectNext("Test response")
                .thenCancel()
                //.expectComplete()
                .verify();
    }
}
