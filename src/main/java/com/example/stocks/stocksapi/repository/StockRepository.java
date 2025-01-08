package com.example.stocks.stocksapi.repository;

import com.example.stocks.stocksapi.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity, String> {
}
