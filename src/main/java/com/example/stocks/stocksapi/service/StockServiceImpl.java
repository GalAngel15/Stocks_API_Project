package com.example.stocks.stocksapi.service;

import com.example.stocks.stocksapi.boundary.*;
import com.example.stocks.stocksapi.utils.RestTemplateProvider;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class StockServiceImpl implements StockService {
    private final Dotenv dotenv = Dotenv.load();
    private final String API_KEY = dotenv.get("ALPHA_VANTAGE_API_KEY");
    private final String BASE_URL = "https://www.alphavantage.co/query";
    private final RestTemplate restTemplate;

    public StockServiceImpl(RestTemplateProvider provider) {
        this.restTemplate = provider.getRestTemplate();
    }

    @Override
    public GlobalQuoteResponse.GlobalQuote getStockQuote(String symbol) {
        String url = BASE_URL + "?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + API_KEY;
        return restTemplate.getForObject(url, GlobalQuoteResponse.class).getGlobalQuote();
    }


    @Override
    public List<IntradayDataPoint> getIntraday(String symbol, String interval) {
        String url = BASE_URL
                + "?function=TIME_SERIES_INTRADAY&symbol=" + symbol
                + "&interval=" + interval
                + "&apikey=" + API_KEY;
        return mapTimeSeriesToDataPoints(restTemplate.getForObject(url, IntradayResponseBoundary.class).getTimeSeries());
    }

    @Override
    public List<IntradayDataPoint> getTimeSeries(String function, String symbol) {
        String url = BASE_URL
                + "?function=" + function
                + "&symbol=" + symbol
                + "&apikey=" + API_KEY;
        return mapTimeSeriesToDataPoints(restTemplate.getForObject(url, IntradayResponseBoundary.class).getTimeSeries());

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

        SmaResponseBoundary response = restTemplate.getForObject(url, SmaResponseBoundary.class);


        return response
                .getTechnicalAnalysis()
                .entrySet()
                .stream()
                .map(entry ->
                        new SmaBoundary(entry.getKey(), entry.getValue().getSma()))
                .collect(Collectors.toList());
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
