package com.example.stocks.stocksapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StockEntity {

    @Id
    private String symbol;
    private double price;

}
