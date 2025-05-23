package com.amiriskhakov.alphabank_test.services;

import com.amiriskhakov.alphabank_test.Utils;
import com.amiriskhakov.alphabank_test.clients.CurrClient;
import com.amiriskhakov.alphabank_test.dto.CurrDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CurrServiceTest {

    @Mock
    private CurrClient currClient;

    private Utils utils;

    private CurrService currService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        utils = new Utils();
        utils.currAppId = "test";
        currService = new CurrService(currClient, utils);
    }

    @Test
    void jsonNodeToDTOReturnsCorrectValues() throws Exception {
        ObjectNode today = objectMapper.createObjectNode();
        today.putObject("rates").put("RUB", 80.0);
        ObjectNode yesterday = objectMapper.createObjectNode();
        yesterday.putObject("rates").put("RUB", 79.5);

        when(currClient.getLatest(anyString())).thenReturn(today);
        when(currClient.getHistorical(anyString(), anyString())).thenReturn(yesterday);

        CurrDTO dto = currService.JsonNodeToDTO();

        assertEquals(80.0, dto.getTodayCourse());
        assertEquals(79.5, dto.getYesterdayCourse());
    }
}
