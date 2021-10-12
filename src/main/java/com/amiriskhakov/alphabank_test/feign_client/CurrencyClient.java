package com.amiriskhakov.alphabank_test.feign_client;

import feign.RequestLine;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Properties;

public interface CurrencyClient {

    @RequestLine("GET /latest.json?app_id=6e6af9997e274c1f8ed80892697dfe18")
    public Object getLatest();


}
