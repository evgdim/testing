package com.example.testing;

import com.example.testing.websocket.KrakenClient;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestWebsocket {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        KrakenClient krakenClientMock = mock(KrakenClient.class);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                ((Consumer<String>) invocationOnMock.getArguments()[0]).accept("Test response");
                return null;
            }
        }).when(krakenClientMock).listenOrderBookUpdates(any());
        krakenClientMock.listenOrderBookUpdates(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Mock response" + s);
            }
        });

        Thread.sleep(1000);
    }
}
