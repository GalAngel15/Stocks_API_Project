package dev.galAngel.stocks.stocksapi.repository;

import dev.galAngel.stocks.stocksapi.entity.Watchlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepository extends MongoRepository<Watchlist, String> {
    Watchlist findByName(String name);

    void deleteByName(String name);
}
