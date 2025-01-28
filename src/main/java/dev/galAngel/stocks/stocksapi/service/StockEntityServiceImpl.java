package dev.galAngel.stocks.stocksapi.service;

import dev.galAngel.stocks.stocksapi.boundary.StockBoundary;
import dev.galAngel.stocks.stocksapi.entity.StockEntity;
import dev.galAngel.stocks.stocksapi.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockEntityServiceImpl implements StockEntityService {

    private final StockRepository watchlistRepository;

    public StockEntityServiceImpl(StockRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }

    public List<StockBoundary> getAllWatchlistItems() {
        return watchlistRepository
                .findAll()
                .stream()
                .map(item-> new StockBoundary(item.getStockSymbol(), item.getPrice()))
                .toList();
    }

    public StockBoundary addStock(String stockSymbol) {
        if (watchlistRepository.findByStockSymbol(stockSymbol)==null) {
            StockEntity stockEntity = new StockEntity(stockSymbol);
            watchlistRepository.save(stockEntity);
            return new StockBoundary(stockEntity.getStockSymbol(), stockEntity.getPrice());
        }
        return null;
    }

    public void removeStock(String stockSymbol) {
        watchlistRepository.deleteByStockSymbol(stockSymbol);
    }

    public void clearWatchlist() {
        watchlistRepository.deleteAll();
    }

    @Override
    public StockBoundary updateStockPrice(String stockSymbol, double price) {
        StockEntity stockEntity = watchlistRepository.findByStockSymbol(stockSymbol);
        if (stockEntity ==null) {
            return null;
        }
        stockEntity.setPrice(price);
        watchlistRepository.save(stockEntity);
        return new StockBoundary(stockEntity.getStockSymbol(), stockEntity.getPrice());
    }
}
