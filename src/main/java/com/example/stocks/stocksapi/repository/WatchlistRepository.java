package com.example.stocks.stocksapi.repository;

import com.example.stocks.stocksapi.entity.WatchlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepository extends JpaRepository<WatchlistItem, Long> {
    boolean existsByStockSymbol(String stockSymbol);

    void deleteByStockSymbol(String stockSymbol);
}
