package com.amiriskhakov.alphabank_test.clients;

import com.amiriskhakov.alphabank_test.Utils;
import com.amiriskhakov.alphabank_test.dto.GifDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@FeignClient(value = "gif")
@Component
@PropertySource("classpath:web.properties")
public interface GifClient {





    @GetMapping(value = "?tag=rich&api_key=ITXQNpcYwlYL5dBQnwkwe8HwLDNk2psr", consumes = MediaType.APPLICATION_JSON_VALUE)
    JsonNode getRichJson();

    @GetMapping(value = "?tag=broke&api_key=ITXQNpcYwlYL5dBQnwkwe8HwLDNk2psr", consumes = MediaType.APPLICATION_JSON_VALUE)
    JsonNode getBrokeJson();

}
