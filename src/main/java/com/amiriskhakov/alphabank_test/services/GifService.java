package com.amiriskhakov.alphabank_test.services;

import com.amiriskhakov.alphabank_test.Utils;
import com.amiriskhakov.alphabank_test.clients.GifClient;
import com.amiriskhakov.alphabank_test.dto.GifDTO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@AllArgsConstructor
public class GifService {

    private GifClient gifClient;
    private Utils utils;

    public GifDTO jsonNodeRichToDTO() {
        JsonNode jsonNode = gifClient.getRichJson(utils.gifApiKey);

        return new GifDTO(jsonNode.findValue("data").findValue("bitly_gif_url").textValue());


    }

    public GifDTO jsonNodeBrokeToDTO() {
        JsonNode jsonNode = gifClient.getBrokeJson(utils.gifApiKey);

        return new GifDTO(jsonNode.findValue("data").findValue("bitly_gif_url").textValue());

    }

}
