package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Hero;
import com.example.demo.repository.HeroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("heroes")
public class HeroController {

    @Autowired
    HeroRepository repository;

    //private final HeroRepository repository;
    
    public HeroController(HeroRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("")
    public ResponseEntity<Object> findUserByName(@RequestParam(name = "name", required = false) String name) {
        if (name == null){
            return ResponseEntity.ok(repository.findAll());
        }
        List<Hero> hero = repository.findByName(name);
        if(hero!=null) {
            return ResponseEntity.ok(hero);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PostMapping("")
    public Hero newHero(@RequestBody Hero hero) {
        return repository.save(hero);
    }

    @GetMapping("/{id}")
    public Hero one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    Hero replaceUser(@RequestBody Hero newHero, @PathVariable Long id) {
        
        return repository.findById(id)
        .map(hero -> {
            hero.setName(newHero.getName());
            hero.setSuperpoderes(newHero.getSuperpoderes());
            return repository.save(hero);
        })
        .orElseGet(() -> {
            newHero.setId(id);
            return repository.save(newHero);
        });
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
    // Ruta personalizada para obtener todos los heroes
    // @GetMapping("")
    // List<Hero> findAll(@RequestParam(required = false) String name) {
    //     if(name == null)
    //         return repository.findAll();
    //     return repository.findByName(name);
    // }
    
    
}
