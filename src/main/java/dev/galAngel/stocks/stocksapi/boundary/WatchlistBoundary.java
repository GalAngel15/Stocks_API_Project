package dev.galAngel.stocks.stocksapi.boundary;

import lombok.Getter;

import java.util.List;

public class WatchlistBoundary {
    private String name;
    @Getter
    private List<StockBoundary> stockBoundary;

    public WatchlistBoundary(String name, List<StockBoundary> stockBoundary) {
        this.name = name;
        this.stockBoundary = stockBoundary;
    }
}
