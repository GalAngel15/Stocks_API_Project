package dev.galAngel.stocks.stocksapi.service;

import dev.galAngel.stocks.stocksapi.boundary.*;
import dev.galAngel.stocks.stocksapi.utils.RestTemplateProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class StockServiceImpl implements StockService {
    @Value("${ALPHA_VANTAGE_API_KEY}")
    private String API_KEY;
    private final String BASE_URL = "https://www.alphavantage.co/query";
    private final RestTemplate restTemplate;

    public StockServiceImpl(RestTemplateProvider provider) {
        this.restTemplate = provider.getRestTemplate();
    }

    @Override
    public GlobalQuoteResponse.GlobalQuote getStockQuote(String symbol) {
        String url = BASE_URL + "?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + API_KEY;
        try {
            GlobalQuoteResponse response = restTemplate.getForObject(url, GlobalQuoteResponse.class);
            if (response == null || response.getGlobalQuote() == null || response.getGlobalQuote().getSymbol() == null) {
                throw new IllegalArgumentException("Stock not found: " + symbol);
            }
            return response.getGlobalQuote();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching stock quote for symbol: " + symbol, e);
        }
    }


    @Override
    public List<IntradayDataPoint> getIntraday(String symbol, String interval) {
        if (symbol == null || symbol.isBlank()) {
            throw new IllegalArgumentException("Symbol cannot be null or empty.");
        }
        if (interval == null || interval.isBlank()) {
            throw new IllegalArgumentException("Interval cannot be null or empty.");
        }
        String url = BASE_URL
                + "?function=TIME_SERIES_INTRADAY&symbol=" + symbol
                + "&interval=" + interval
                + "&apikey=" + API_KEY;
        try {
            IntradayResponseBoundary response = restTemplate.getForObject(url, IntradayResponseBoundary.class);
            if (response == null || response.getTimeSeries() == null) {
                throw new RuntimeException("Failed to fetch intraday data. Response is empty.");
            }
            return mapTimeSeriesToDataPoints(response.getTimeSeries());
        } catch (Exception e) {
            throw new RuntimeException("Error fetching intraday data for symbol: " + symbol, e);
        }
    }

    @Override
    public List<IntradayDataPoint> getTimeSeries(String function, String symbol) {
        if (symbol == null || symbol.isBlank()) {
            throw new IllegalArgumentException("Symbol cannot be null or empty.");
        }
        if (function == null || function.isBlank()) {
            throw new IllegalArgumentException("Function cannot be null or empty.");
        }
        String url = BASE_URL
                + "?function=" + function
                + "&symbol=" + symbol
                + "&apikey=" + API_KEY;
        try {
            IntradayResponseBoundary response = restTemplate.getForObject(url, IntradayResponseBoundary.class);
            if (response == null || response.getTimeSeries() == null) {
                throw new RuntimeException("Failed to fetch intraday data. Response is empty.");
            }
            return mapTimeSeriesToDataPoints(response.getTimeSeries());
        } catch (Exception e) {
            throw new RuntimeException("Error fetching intraday data for symbol: " + symbol, e);
        }
    }

    @Override
    public List<SmaBoundary> getIndicator(TechIndicatorsBoundary params) {
        String url = BASE_URL
                + "?function=" + params.getFunction()
                + "&symbol=" + params.getSymbol()
                + "&interval=" + params.getInterval()
                + "&time_period=" + params.getTime_period()
                + "&series_type=" + params.getSeries_type()
                + "&apikey=" + API_KEY;
        try {
            SmaResponseBoundary response = restTemplate.getForObject(url, SmaResponseBoundary.class);
            if (response == null || response.getTechnicalAnalysis() == null) {
                throw new RuntimeException("Failed to fetch indicator data. Response is empty.");
            }
            return response
                    .getTechnicalAnalysis()
                    .entrySet()
                    .stream()
                    .map(entry ->
                            new SmaBoundary(entry.getKey(), entry.getValue().getSma()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error fetching indicator data for symbol: " + params.getSymbol(), e);
        }
    }

    private List<IntradayDataPoint> mapTimeSeriesToDataPoints(Map<String, Map<String, TimeSeriesDataBoundary>> timeSeries) {
        List<IntradayDataPoint> response = new ArrayList<>();
        for (Map.Entry<String, Map<String, TimeSeriesDataBoundary>> entry : timeSeries.entrySet()) {
            for (Map.Entry<String, TimeSeriesDataBoundary> innerEntry : entry.getValue().entrySet()) {
                IntradayDataPoint point = new IntradayDataPoint(
                        innerEntry.getKey(),
                        innerEntry.getValue().getOpen(),
                        innerEntry.getValue().getHigh(),
                        innerEntry.getValue().getLow(),
                        innerEntry.getValue().getClose(),
                        innerEntry.getValue().getVolume()
                );
                response.add(point);
            }
        }
        return response;
    }

}
