package dev.galAngel.stocks.stocksapi.controller;

import dev.galAngel.stocks.stocksapi.boundary.GlobalQuoteResponse;
import dev.galAngel.stocks.stocksapi.boundary.IntradayDataPoint;
import dev.galAngel.stocks.stocksapi.boundary.SmaBoundary;
import dev.galAngel.stocks.stocksapi.boundary.TechIndicatorsBoundary;
import dev.galAngel.stocks.stocksapi.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/stock"})
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public GlobalQuoteResponse.GlobalQuote getStockQuote(@RequestParam String symbol) {
        return stockService.getStockQuote(symbol);
    }

    @GetMapping("/intraday")
    public List<IntradayDataPoint> getIntraday(
            @RequestParam String symbol,
            @RequestParam(required = false, defaultValue = "5min") String interval
    ) {
        return stockService.getIntraday(symbol, interval);
    }

    @GetMapping("/time-series")
    public List<IntradayDataPoint> getTimeSeries(
            @RequestParam(required = false, defaultValue = "TIME_SERIES_DAILY") String function,
            @RequestParam String symbol
    ) {
        return stockService.getTimeSeries(function, symbol);
    }

    @GetMapping("/indicators")
    public List<SmaBoundary> getIndicator(
            @RequestParam String function,
            @RequestParam String symbol,
            @RequestParam String interval,
            @RequestParam int time_period,
            @RequestParam String series_type
    ) {
        return stockService.getIndicator(new TechIndicatorsBoundary(function, symbol, interval, time_period, series_type));
    }
}
