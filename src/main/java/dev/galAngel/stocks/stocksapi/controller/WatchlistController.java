package dev.galAngel.stocks.stocksapi.controller;

import dev.galAngel.stocks.stocksapi.boundary.StockBoundary;
import dev.galAngel.stocks.stocksapi.boundary.WatchlistBoundary;
import dev.galAngel.stocks.stocksapi.entity.Watchlist;
import dev.galAngel.stocks.stocksapi.service.StockEntityService;
import dev.galAngel.stocks.stocksapi.service.WatchlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlists")
public class WatchlistController {

    private final WatchlistService watchlistService;
    private final StockEntityService stockService;

    public WatchlistController(WatchlistService watchlistService, StockEntityService stockService)
    {
        this.watchlistService = watchlistService;
        this.stockService = stockService;
    }

    @PostMapping
    public Watchlist createWatchlist(@RequestParam String name) {
        return watchlistService.createWatchlist(name);
    }

    @GetMapping
    public List<Watchlist> getAllWatchlists() {
        return watchlistService.getAllWatchlists();
    }

    @GetMapping("/stocks")
    public List<StockBoundary> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{name}")
    public WatchlistBoundary getWatchlistByName(@PathVariable String name) {
        return watchlistService.getWatchlistByName(name);
    }

    @DeleteMapping("/{name}")
    public void deleteWatchlist(@PathVariable String name) {
        watchlistService.deleteWatchlist(name);
    }

    @DeleteMapping("/stock/{name}")
    public void deleteStock(@PathVariable String name) {
        stockService.removeStock(name.toUpperCase());
    }

    @PutMapping("/{name}/add-stock")
    public WatchlistBoundary addStockToWatchlist(@PathVariable String name, @RequestParam String stockSymbol) {
        return watchlistService.addStockToWatchlist(name, stockSymbol.toUpperCase());
    }

    @PutMapping("/{name}/remove-stock")
    public WatchlistBoundary removeStockFromWatchlist(@PathVariable String name, @RequestParam String stockSymbol) {
        return watchlistService.removeStockFromWatchlist(name, stockSymbol.toUpperCase());
    }
}
