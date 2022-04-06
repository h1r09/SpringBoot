package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "heroes")
public class Hero {

    public Hero() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Superpoder> Superpoder;

    public Hero(String name, List<Superpoder> Superpoder) {
        this.name = name;
        this.Superpoder = Superpoder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Superpoder> getSuperpoder() {
        return Superpoder;
    }

    public void setSuperpoder(List<Superpoder> Superpoder) {
        this.Superpoder = Superpoder;
    }

    @Override
    public String toString() {
        return "Hero [id=" + id + ", Nombre=" + name + ", Superpoder=" + Superpoder + "]";
    }

}