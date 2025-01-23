package dev.galAngel.stocks.stocksapi.controller;

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
    public List<String> getWatchlist() {
        return watchlistService.getAllWatchlistItems();
    }

    @PostMapping("/{stockSymbol}")
    public String addStockToWatchlist(@PathVariable String stockSymbol) {
        return watchlistService.addStock(stockSymbol);
    }

    @Transactional
    @DeleteMapping("/{symbol}")
    public String removeStockFromWatchlist(@PathVariable String symbol) {
        watchlistService.removeStock(symbol);
        return "Stock removed from watchlist";
    }

    @DeleteMapping
    public void clearWatchlist() {
        watchlistService.clearWatchlist();
    }
}
