package dev.galAngel.stocks.stocksapi.boundary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WatchlistItemBoundary {

    private String stockSymbol;
    private double price;

    public WatchlistItemBoundary() {
    }

    public WatchlistItemBoundary(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public WatchlistItemBoundary(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
    }
}
