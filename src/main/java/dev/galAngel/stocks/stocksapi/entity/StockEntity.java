package dev.galAngel.stocks.stocksapi.entity;


import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "watchlist")
public class StockEntity {

    @Id
    private String id;
    private String stockSymbol;
    private double price;

    public StockEntity() {
    }

    public StockEntity(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public StockEntity(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
    }

    public boolean setPrice(double price) {
        if(price < 0) {
            return false;
        }
        this.price = price;
        return true;
    }
}
