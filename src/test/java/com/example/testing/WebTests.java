package com.example.testing;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


//@WireMockTest(httpPort = 9999)
public class WebTests {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);
    private HttpClient http = HttpClient.newHttpClient();
    @Test
    public void testGetCall() throws IOException, InterruptedException {
        stubFor(get("/get-test")
                .willReturn(
                        ok().withHeader("Content-Type","application/json")
                                                 .withBody("{\"test\":1}"))
        );
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8089/get-test")).GET().build();
        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
    }
}
