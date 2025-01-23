package com.example.stocks.stocksapi.repository;

import com.example.stocks.stocksapi.entity.StockEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StockRepository extends MongoRepository<StockEntity, String> {
}
