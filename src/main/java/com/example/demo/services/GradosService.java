package com.example.demo.services;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.example.demo.dto.GradosDto;

@Component("gradosService")
public class GradosService {

    public List<GradosDto> retrieveGrados() {

        List<GradosDto> gradosList = new ArrayList<>();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.webkit().launch();
        Page page = browser.newPage();
        page.navigate("https://www.ual.es/estudios/grados");
        page.waitForSelector(
                "body > div > div > div.container.main > div > section > div:nth-child(2) > div:nth-child(17) > div:nth-child(2) > div:nth-child(9) > div > ul > li:nth-child(2) > a > span");
        Document webPage = Jsoup.parse(page.content());
        Elements grados = webPage.select(".sinvinetas > li > a");

        for (Element grado : grados) {
            if (grado == null)
                continue;
            Element nombrElement = grado.selectFirst(".ng-binding");
            if (nombrElement == null)
                continue;
            String nombre = nombrElement.text();
            String codigo = grado.attr("href").replace("/estudios/grados/presentacion/", "");
            gradosList.add(new GradosDto(nombre, codigo));
        }
        return gradosList;
    }
    
}
