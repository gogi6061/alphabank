package com.amiriskhakov.alphabank_test.clients;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;


@FeignClient(value = "gif", url = "https://api.giphy.com/v1/gifs/random")
@Component
@PropertySource("classpath:web.properties")
public interface GifClient {

    @GetMapping(value = "?tag=rich&api_key={api_key}", consumes = MediaType.APPLICATION_JSON_VALUE)
    JsonNode getRichJson(@PathVariable("api_key") String apiKey);

    @GetMapping(value = "?tag=broke&api_key={api_key}", consumes = MediaType.APPLICATION_JSON_VALUE)
    JsonNode getBrokeJson(@PathVariable("api_key") String apiKey);

}
