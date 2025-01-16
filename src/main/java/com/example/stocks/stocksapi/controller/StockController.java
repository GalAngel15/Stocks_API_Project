package com.example.stocks.stocksapi.controller;

import com.example.stocks.stocksapi.boundary.GlobalQuoteResponse;
import com.example.stocks.stocksapi.boundary.IntradayDataPoint;
import com.example.stocks.stocksapi.boundary.IntradayResponseBoundary;
import com.example.stocks.stocksapi.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = { "/stocks" })
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stock")
    public GlobalQuoteResponse.GlobalQuote getStockQuote(@RequestParam String symbol) {
        return stockService.getStockQuote(symbol);
    }

    @GetMapping("/stock/intraday")
    public List<IntradayDataPoint> getIntraday(
            @RequestParam String symbol,
            @RequestParam(required = false, defaultValue = "5min") String interval
    ) {
        return stockService.getIntraday(symbol, interval);
    }
}
