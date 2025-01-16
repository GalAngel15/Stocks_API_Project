package com.example.stocks.stocksapi.service;

import com.example.stocks.stocksapi.entity.WatchlistItem;
import com.example.stocks.stocksapi.repository.WatchlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    private final WatchlistRepository watchlistRepository;

    public WatchlistServiceImpl(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }

    public List<String> getAllWatchlistItems() {
        return watchlistRepository.findAll()
                .stream()
                .map(WatchlistItem::getStockSymbol)
                .collect(Collectors.toList());
    }

    public String addStock(String stockSymbol) {
        if (!watchlistRepository.existsByStockSymbol(stockSymbol)) {
            watchlistRepository.save(new WatchlistItem(stockSymbol));
            return stockSymbol;
        }
        return "Stock already exists in watchlist";
    }

    public void removeStock(String stockSymbol) {
        watchlistRepository.deleteByStockSymbol(stockSymbol);
    }

    public void clearWatchlist() {
        watchlistRepository.deleteAll();
    }
}
