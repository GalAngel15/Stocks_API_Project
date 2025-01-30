package dev.galAngel.stocks.stocksapi.service;

import dev.galAngel.stocks.stocksapi.boundary.StockBoundary;
import dev.galAngel.stocks.stocksapi.entity.StockEntity;
import dev.galAngel.stocks.stocksapi.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockEntityServiceImpl implements StockEntityService {

    private final StockRepository stockRepository;

    public StockEntityServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<StockBoundary> getAllStocks() {
        return stockRepository
                .findAll()
                .stream()
                .map(item-> new StockBoundary(item.getStockSymbol(), item.getPrice()))
                .toList();
    }

    public StockBoundary addStock(String stockSymbol) {
        if (stockRepository.findByStockSymbol(stockSymbol)==null) {
            StockEntity stockEntity = new StockEntity(stockSymbol);
            stockRepository.save(stockEntity);
            return new StockBoundary(stockEntity.getStockSymbol(), stockEntity.getPrice());
        }
        return null;
    }

    public void removeStock(String stockSymbol) {
        stockRepository.deleteByStockSymbol(stockSymbol);
    }


    @Override
    public StockBoundary updateStockPrice(String stockSymbol, double price) {
        StockEntity stockEntity = stockRepository.findByStockSymbol(stockSymbol);
        if (stockEntity ==null) {
            return null;
        }
        stockEntity.setPrice(price);
        stockRepository.save(stockEntity);
        return new StockBoundary(stockEntity.getStockSymbol(), stockEntity.getPrice());
    }

    @Override
    public StockBoundary getStockBySymbol(String stockSymbol) {
        StockEntity stockEntity = stockRepository.findByStockSymbol(stockSymbol);
        if (stockEntity ==null) {
            return null;
        }
        return new StockBoundary(stockEntity.getStockSymbol(), stockEntity.getPrice());
    }
}
