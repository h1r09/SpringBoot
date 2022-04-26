package com.example.demo.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CovidDataDto;

@Component("covidDataService")
public class CovidDataService {
    public List<CovidDataDto> retrieveCovidData() {

        List<CovidDataDto> covidData = new ArrayList<>();

        try {
            Document webPage = Jsoup.connect("https://en.wikipedia.org/wiki/COVID-19_pandemic_by_country_and_territory")
                    .get();
            Element tbody = webPage.getElementById("covid-19-cases-deaths-and-rates-by-location").getElementsByTag("tbody").get(0);

            List<Element> rows = tbody.children().subList(2, tbody.children().size());

            for (Element row : rows) {

                Elements ths = row.getElementsByTag("th");
                if(ths.isEmpty())
                    continue;

                String country = ths.get(0).text();
                Elements tds = row.getElementsByTag("td");

                if (tds.size() < 3)
                    continue;

                Integer cases = toIntOrNull(tds.get(1).text());    
                Integer deaths = toIntOrNull(tds.get(2).text());   
                Integer recovered = toIntOrNull(tds.get(3).text());

                covidData.add(new CovidDataDto(country, cases, deaths, recovered)); 
            }

            return covidData;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Integer toIntOrNull(String replace) {
        try {
            return Integer.parseInt(replace.replace(",", ""));
        } catch (NumberFormatException e) {
            return null;
        }
    }    
}
