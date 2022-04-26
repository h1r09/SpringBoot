package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CovidDataDto;
import com.example.demo.services.CovidDataService;

@RestController
@RequestMapping("/covid")
public class CovidDataController {
    @Autowired
    private CovidDataService covidDataService;
    @GetMapping("data") 
    public ResponseEntity<List<CovidDataDto>> getCovidData() {
        return new ResponseEntity<List<CovidDataDto>>(covidDataService.retrieveCovidData(),
                HttpStatus.OK);
    }
}
