package dev.galAngel.stocks.stocksapi.boundary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockBoundary {

    private String stockSymbol;
    private double price;

    public StockBoundary() {
    }

    public StockBoundary(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public StockBoundary(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
    }
}
