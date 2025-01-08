package com.example.stocks.stocksapi.service;

import com.example.stocks.stocksapi.boundary.GlobalQuoteResponse;

public interface StockService {
    public GlobalQuoteResponse.GlobalQuote getStockQuote(String symbol);
}
