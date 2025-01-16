package com.example.stocks.stocksapi.service;

import java.util.List;

public interface WatchlistService {

    List<String> getAllWatchlistItems();

    String addStock(String stockSymbol);

    void removeStock(String stockSymbol);

    void clearWatchlist();

}
