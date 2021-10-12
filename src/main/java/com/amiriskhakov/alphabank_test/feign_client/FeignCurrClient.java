package com.amiriskhakov.alphabank_test.feign_client;

import feign.Client;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.slf4j.LoggerFactory;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Component;

public class FeignCurrClient {
    public static void main(String[] args) {
        CurrencyClient client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(CurrencyClient.class))
                .logLevel(Logger.Level.FULL)
                .target(CurrencyClient.class, "https://openexchangerates.org/api");

        client.getLatest();

    }
}
