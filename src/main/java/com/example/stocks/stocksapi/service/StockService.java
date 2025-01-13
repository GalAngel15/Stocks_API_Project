package com.example.stocks.stocksapi.service;

import com.example.stocks.stocksapi.boundary.GlobalQuoteResponse;
import com.example.stocks.stocksapi.boundary.IntradayResponseBoundary;

public interface StockService {
    public GlobalQuoteResponse.GlobalQuote getStockQuote(String symbol);
    public IntradayResponseBoundary getIntraday(String symbol, String interval);
}
