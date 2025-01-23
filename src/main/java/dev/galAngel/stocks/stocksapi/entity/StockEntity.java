package dev.galAngel.stocks.stocksapi.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stocks")
public class StockEntity {

    @Id
    private String symbol;
    private double price;

}
