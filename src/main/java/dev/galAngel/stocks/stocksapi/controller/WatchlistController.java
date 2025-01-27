package dev.galAngel.stocks.stocksapi.controller;

import dev.galAngel.stocks.stocksapi.boundary.WatchlistItemBoundary;
import dev.galAngel.stocks.stocksapi.entity.WatchlistItem;
import dev.galAngel.stocks.stocksapi.service.WatchlistService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    private final WatchlistService watchlistService;

    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    @GetMapping
    public List<WatchlistItemBoundary> getWatchlist() {
        return watchlistService.getAllWatchlistItems();
    }

    @PostMapping("/{stockSymbol}")
    public WatchlistItemBoundary addStockToWatchlist(@PathVariable String stockSymbol) {
        return watchlistService.addStock(stockSymbol);
    }

    @PutMapping("/{stockSymbol}")
    public WatchlistItemBoundary updateStockInWatchlist(@PathVariable String stockSymbol, @PathVariable double price) {
        return watchlistService.updateStockPrice(stockSymbol, price);
    }

    @Transactional
    @DeleteMapping("/{symbol}")
    public void removeStockFromWatchlist(@PathVariable String symbol) {
        watchlistService.removeStock(symbol);
    }

    @DeleteMapping
    public void clearWatchlist() {
        watchlistService.clearWatchlist();
    }
}
