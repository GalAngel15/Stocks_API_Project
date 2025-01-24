package dev.galAngel.stocks.stocksapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface StockRepository extends MongoRepository<StockEntity, String> {
}
