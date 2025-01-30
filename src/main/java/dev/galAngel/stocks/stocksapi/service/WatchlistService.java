package dev.galAngel.stocks.stocksapi.service;

import dev.galAngel.stocks.stocksapi.boundary.WatchlistBoundary;
import dev.galAngel.stocks.stocksapi.entity.Watchlist;

import java.util.List;

public interface WatchlistService {
    Watchlist createWatchlist(String name);
    List<Watchlist> getAllWatchlists();
    WatchlistBoundary getWatchlistByName(String name);
    void deleteWatchlist(String name);
    Watchlist addStockToWatchlist(String listName, String stockSymbol);
    Watchlist removeStockFromWatchlist(String listId, String stockSymbol);
}

