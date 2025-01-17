package com.example.stocks.stocksapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class WatchlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
