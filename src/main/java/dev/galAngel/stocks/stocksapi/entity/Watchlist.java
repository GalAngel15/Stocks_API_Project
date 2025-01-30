package dev.galAngel.stocks.stocksapi.entity;

import dev.galAngel.stocks.stocksapi.boundary.StockBoundary;
import dev.galAngel.stocks.stocksapi.boundary.WatchlistBoundary;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "watchlists")
public class Watchlist {
    @Id
    private String id;
    @Getter @Setter
    private String name;
    @Getter
    private List<String> stockSymbols;

    public Watchlist(String name) {
        this.name = name;
        this.stockSymbols=new ArrayList<>();
    }

    public void addStock(String stockSymbol) {
        if(!stockSymbols.contains(stockSymbol))
            stockSymbols.add(stockSymbol);
    }

    public void removeStock(String stockSymbol) {
        stockSymbols.remove(stockSymbol);
    }



}
