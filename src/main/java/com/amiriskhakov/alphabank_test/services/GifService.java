package com.amiriskhakov.alphabank_test.services;

import com.amiriskhakov.alphabank_test.clients.CurrClient;
import com.amiriskhakov.alphabank_test.clients.GifClient;
import com.amiriskhakov.alphabank_test.dto.GifDTO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GifService {


    private GifClient gifClient;

    public GifDTO jsonNodeRichToDTO() {
        JsonNode jsonNode = gifClient.getRichJson();
        return new GifDTO(jsonNode.findValue("data").findValue("bitly_gif_url").textValue());


    }

    public GifDTO jsonNodeBrokeToDTO() {
        JsonNode jsonNode = gifClient.getBrokeJson();
        return new GifDTO(jsonNode.findValue("data").findValue("bitly_gif_url").textValue());

    }

}
