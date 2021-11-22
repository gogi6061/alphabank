package com.amiriskhakov.alphabank_test.clients;

import com.amiriskhakov.alphabank_test.dto.CurrDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@FeignClient(value = "curr", url = "https://openexchangerates.org/api")
@Component
public interface CurrClient {


    @GetMapping(value = "/latest.json?app_id=6e6af9997e274c1f8ed80892697dfe18")
    JsonNode getLatest();

    @GetMapping(value = "/historical/{date}.json?app_id=6e6af9997e274c1f8ed80892697dfe18")
    JsonNode getHistorical(@PathVariable("date") String date);


}
