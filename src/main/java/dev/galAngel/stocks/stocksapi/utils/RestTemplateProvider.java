package dev.galAngel.stocks.stocksapi.utils;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Getter
public class RestTemplateProvider {

    private final RestTemplate restTemplate;

    public RestTemplateProvider() {
        this.restTemplate = new RestTemplate(); // ניתן להוסיף הגדרות מיוחדות כאן
    }

    public RestTemplate getRestTemplate() {
        return this.restTemplate;
    }
}

