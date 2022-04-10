package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Hero;
import com.example.demo.repository.HeroRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("heroes")
public class HeroController {

    private final HeroRepository repository;
    
    public HeroController(HeroRepository repository) {
        this.repository = repository;
    }

    // Ruta personalizada para obtener todos los heroes
    @GetMapping("")
    List<Hero> findAll(@RequestParam(required = false) String name) {
        if(name == null)
            return repository.findAll();
        return repository.findByName(name);
    }
    
    
}
