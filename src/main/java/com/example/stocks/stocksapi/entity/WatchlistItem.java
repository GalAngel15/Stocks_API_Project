package com.example.stocks.stocksapi.entity;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "watchlist")
public class WatchlistItem {

    @Id
    private String id;
    private String stockSymbol;
    private double price;

    public WatchlistItem() {
    }

    public WatchlistItem(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public WatchlistItem(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
    }

}
