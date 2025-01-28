package dev.galAngel.stocks.stocksapi.repository;

import dev.galAngel.stocks.stocksapi.entity.StockEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<StockEntity, Long> {
    StockEntity findByStockSymbol(String stockSymbol);
    void deleteByStockSymbol(String stockSymbol);
}
