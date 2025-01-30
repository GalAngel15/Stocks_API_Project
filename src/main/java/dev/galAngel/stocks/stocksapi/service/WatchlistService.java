package dev.galAngel.stocks.stocksapi.service;

import dev.galAngel.stocks.stocksapi.boundary.WatchlistBoundary;
import dev.galAngel.stocks.stocksapi.entity.Watchlist;

import java.util.List;

public interface WatchlistService {
    Watchlist createWatchlist(String name);
    List<Watchlist> getAllWatchlists();
    WatchlistBoundary getWatchlistByName(String name);
    void deleteWatchlist(String name);
    WatchlistBoundary addStockToWatchlist(String listName, String stockSymbol);
    WatchlistBoundary removeStockFromWatchlist(String listId, String stockSymbol);
}

