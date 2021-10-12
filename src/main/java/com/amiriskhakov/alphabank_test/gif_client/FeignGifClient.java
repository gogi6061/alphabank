package com.amiriskhakov.alphabank_test.gif_client;

import com.amiriskhakov.alphabank_test.feign_client.CurrencyClient;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.stereotype.Component;

public class FeignGifClient {
    public static void main(String[] args) {
        GifClient client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(GifClient.class))
                .logLevel(Logger.Level.FULL)
                .target(GifClient.class, "https://api.giphy.com/v1/gifs");

        client.getBrokeGif();

    }
}
