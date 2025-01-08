package com.example.stocks.stocksapi.service;

import com.example.stocks.stocksapi.boundary.GlobalQuoteResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class StockServiceImpl implements StockService{
    private final Dotenv dotenv = Dotenv.load();
    private final String API_KEY = dotenv.get("ALPHA_VANTAGE_API_KEY");
    private final String BASE_URL = "https://www.alphavantage.co/query";


    @Override
    public GlobalQuoteResponse.GlobalQuote getStockQuote(String symbol) {
        String url = BASE_URL + "?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + API_KEY;
        RestTemplate restTemplate = new RestTemplate();

        try {
            GlobalQuoteResponse response = restTemplate.getForObject(url, GlobalQuoteResponse.class);
            if (response != null && response.getGlobalQuote() != null) {
                return response.getGlobalQuote();
            } else {
                throw new RuntimeException("לא ניתן היה לקבל את המידע עבור המניה: " + symbol);
            }
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("שגיאה בקריאת ה-API: " + e.getMessage());
        }
    }
}
