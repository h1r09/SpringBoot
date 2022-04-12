package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Superpoder> Superpoderes;

    public Hero(String name) {
        this.name = name;
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

    public List<Superpoder> getSuperpoderes() {
        return Superpoderes;
    }

    public void setSuperpoderes(List<Superpoder> Superpoderes) {
        this.Superpoderes = Superpoderes;
    }

    @Override
    public String toString() {
        return "Hero [id=" + id + ", Nombre=" + name + ", Superpoder=" + Superpoderes + "]";
    }

}