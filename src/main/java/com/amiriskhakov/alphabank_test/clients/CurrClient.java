package com.amiriskhakov.alphabank_test.clients;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "curr", url = "https://openexchangerates.org/api")
@Component
public interface CurrClient {

    @GetMapping(value = "/latest.json?app_id={app_id}")
    JsonNode getLatest(@PathVariable("app_id") String appId);

    @GetMapping(value = "/historical/{date}.json?app_id={app_id}")
    JsonNode getHistorical(@PathVariable("date") String date, @PathVariable("app_id") String appId);

}
