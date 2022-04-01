package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Hero {
    
    private long id;
    private String name;
    private String [] superpoderes;
    
    public Hero() {

    }

    public Hero(long id, String name, String[] superpoderes) {
        this.id = id;
        this.name = name;
        this.superpoderes = superpoderes;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSuperpoderes() {
        return this.superpoderes;
    }

    public void setSuperpoderes(String[] superpoderes) {
        this.superpoderes = superpoderes;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", superpoderes='" + getSuperpoderes() + "'" +
            "}";
    }
    
}