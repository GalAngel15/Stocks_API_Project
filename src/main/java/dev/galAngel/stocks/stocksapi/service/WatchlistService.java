package dev.galAngel.stocks.stocksapi.service;

import dev.galAngel.stocks.stocksapi.boundary.WatchlistItemBoundary;
import dev.galAngel.stocks.stocksapi.entity.WatchlistItem;

import java.util.List;

public interface WatchlistService {

    List<WatchlistItemBoundary> getAllWatchlistItems();

    WatchlistItemBoundary addStock(String stockSymbol);

    void removeStock(String stockSymbol);

    void clearWatchlist();

    WatchlistItemBoundary updateStockPrice(String stockSymbol, double price);
}
