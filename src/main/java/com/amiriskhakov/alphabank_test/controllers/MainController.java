package com.amiriskhakov.alphabank_test.controllers;

import com.amiriskhakov.alphabank_test.dto.CurrDTO;
import com.amiriskhakov.alphabank_test.dto.GifDTO;
import com.amiriskhakov.alphabank_test.services.CurrService;
import com.amiriskhakov.alphabank_test.services.GifService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

    private CurrService currService;

    private GifService gifService;


    @GetMapping("/gif")
    public ResponseEntity<GifDTO> get() {

        CurrDTO currDTO = currService.JsonNodeToDTO();


        if (currDTO.getTodayCourse() > currDTO.getYesterdayCourse()) {
            return new ResponseEntity<>(gifService.jsonNodeBrokeToDTO(), HttpStatus.OK);
        }

        return new ResponseEntity<>(gifService.jsonNodeRichToDTO(), HttpStatus.OK);
    }


}
