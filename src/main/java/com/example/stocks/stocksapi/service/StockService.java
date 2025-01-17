package com.example.stocks.stocksapi.service;

import com.example.stocks.stocksapi.boundary.*;

import java.util.List;

public interface StockService {
    GlobalQuoteResponse.GlobalQuote getStockQuote(String symbol);

    List<IntradayDataPoint> getIntraday(String symbol, String interval);

    List<IntradayDataPoint> getTimeSeries(String function, String symbol);

    List<SmaBoundary> getIndicator(TechIndicatorsBoundary params);
}
