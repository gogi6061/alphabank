package com.amiriskhakov.alphabank_test.services;

import com.amiriskhakov.alphabank_test.Utils;
import com.amiriskhakov.alphabank_test.clients.CurrClient;
import com.amiriskhakov.alphabank_test.dto.CurrDTO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class CurrService {

    private CurrClient currClient;
    private Utils utils;

    public CurrDTO JsonNodeToDTO() {
        JsonNode jsonNodeNow = currClient.getLatest(utils.currAppId);
        JsonNode jsonNodeTomorrow = currClient.getHistorical(LocalDate.now().minusDays(1).toString(),
                utils.currAppId);

        return new CurrDTO(Double.parseDouble(jsonNodeNow.findValue("rates").findValue("RUB").toString())
                , Double.parseDouble(jsonNodeTomorrow.findValue("rates").findValue("RUB").toString()));

    }

}
