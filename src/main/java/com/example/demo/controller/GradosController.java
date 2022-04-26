package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GradosDto;
import com.example.demo.services.GradosService;

@RestController
@RequestMapping("/grados")
public class GradosController {
    
    @Autowired
    private GradosService gradosService;


    @GetMapping("data")
    public ResponseEntity<List<GradosDto>> getGrados() {
        return new ResponseEntity<List<GradosDto>>(gradosService.retrieveGrados(),
                HttpStatus.OK);
    }
}
