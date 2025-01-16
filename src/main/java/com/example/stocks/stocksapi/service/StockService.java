package com.example.stocks.stocksapi.service;

import com.example.stocks.stocksapi.boundary.GlobalQuoteResponse;
import com.example.stocks.stocksapi.boundary.IntradayDataPoint;
import com.example.stocks.stocksapi.boundary.IntradayResponseBoundary;

import java.util.List;

public interface StockService {
    public GlobalQuoteResponse.GlobalQuote getStockQuote(String symbol);
    public List<IntradayDataPoint> getIntraday(String symbol, String interval);
}
