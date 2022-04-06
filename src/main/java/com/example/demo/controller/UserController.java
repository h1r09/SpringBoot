package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public List<User> allUsers() {
        return (List<User>) repository.findAll();
    }

    @GetMapping("/user/name/{name}")
    public List<User> findByName(@PathVariable("name") String name) {
        return repository.findByName(name);
    }

    // Ruta personalizada para buscar por apellido
    @GetMapping("/user/apellido/{apellido}")
    public List<User> findByApellido(@PathVariable("apellido") String apellido) {
        return repository.findByApellido(apellido);
    }
}
