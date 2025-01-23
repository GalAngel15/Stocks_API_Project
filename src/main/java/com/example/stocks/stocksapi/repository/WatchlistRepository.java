package com.example.stocks.stocksapi.repository;

import com.example.stocks.stocksapi.entity.WatchlistItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepository extends MongoRepository<WatchlistItem, Long> {
    boolean existsByStockSymbol(String stockSymbol);

    void deleteByStockSymbol(String stockSymbol);
}
