package com.wellsfargo.portfoliorecommendationengine.controller;

import com.wellsfargo.portfoliorecommendationengine.service.StockWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path="/StockWebService")
public class StockWebServiceController {

    @Autowired
    private StockWebService stockWebService;

    @CrossOrigin
    @GetMapping("/loadTimeSeriesData")
    public ResponseEntity<String> loadTimeSeriesData() throws IOException {

        return new ResponseEntity<>(stockWebService.loadTimeSeriesData(), HttpStatus.OK);
    }
}
