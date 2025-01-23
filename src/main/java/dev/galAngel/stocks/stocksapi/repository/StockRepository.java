package dev.galAngel.stocks.stocksapi.repository;

import dev.galAngel.stocks.stocksapi.entity.StockEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StockRepository extends MongoRepository<StockEntity, String> {
}
