package com.example.demo.dto;

public class CovidDataDto {
    
    public String country;
    public Integer cases;
    public Integer deaths;
    public Integer recovered;

    public CovidDataDto(String country, Integer cases, Integer deaths, Integer recovered) {
        this.country = country;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public CovidDataDto() {
    }
}
