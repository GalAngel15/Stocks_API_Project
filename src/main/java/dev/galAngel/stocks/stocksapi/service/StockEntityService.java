package dev.galAngel.stocks.stocksapi.service;

import dev.galAngel.stocks.stocksapi.boundary.StockBoundary;

import java.util.List;

public interface StockEntityService {

    List<StockBoundary> getAllStocks();

    StockBoundary addStock(String stockSymbol);

    void removeStock(String stockSymbol);

    void clearWatchlist();

    StockBoundary updateStockPrice(String stockSymbol, double price);
}
