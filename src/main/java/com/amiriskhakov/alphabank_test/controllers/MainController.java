package com.amiriskhakov.alphabank_test.controllers;

import com.amiriskhakov.alphabank_test.dto.CurrDTO;
import com.amiriskhakov.alphabank_test.dto.GifDTO;
import com.amiriskhakov.alphabank_test.services.CurrService;
import com.amiriskhakov.alphabank_test.services.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private CurrService currService;

    @Autowired
    private GifService gifService;


    @GetMapping("/get_gif}")
    public ResponseEntity<GifDTO> get() {

        CurrDTO currDTO = currService.JsonNodeToDTO();


        if (currDTO.getTodayCourse() > currDTO.getTomorrowCourse()) {
            return new ResponseEntity<>(gifService.jsonNodeBrokeToDTO(), HttpStatus.OK);
        }

        return new ResponseEntity<>(gifService.jsonNodeRichToDTO(), HttpStatus.OK);
    }


}
