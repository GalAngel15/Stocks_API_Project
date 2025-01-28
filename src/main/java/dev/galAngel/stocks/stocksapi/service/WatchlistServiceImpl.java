package dev.galAngel.stocks.stocksapi.service;

import dev.galAngel.stocks.stocksapi.entity.StockEntity;
import dev.galAngel.stocks.stocksapi.entity.Watchlist;
import dev.galAngel.stocks.stocksapi.repository.StockRepository;
import dev.galAngel.stocks.stocksapi.repository.WatchlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    private final WatchlistRepository watchlistRepository;
    private final StockEntityService stockService;

    public WatchlistServiceImpl(WatchlistRepository watchlistRepository,StockEntityService stockService) {
        this.watchlistRepository = watchlistRepository;
        this.stockService=stockService;
    }

    @Override
    public Watchlist createWatchlist(String name) {
        Watchlist watchlist = new Watchlist(name);
        return watchlistRepository.save(watchlist);
    }

    @Override
    public List<Watchlist> getAllWatchlists() {
        return watchlistRepository.findAll();
    }

    @Override
    public Watchlist getWatchlistByName(String name) {
        return watchlistRepository.findByName(name);
    }

    @Override
    public void deleteWatchlist(String name) {
        watchlistRepository.deleteByName(name);
    }

    @Override
    public Watchlist addStockToWatchlist(String listName, String stockSymbol) {
        Watchlist watchlist = watchlistRepository.findByName(listName);
        if (watchlist != null) {
            watchlist.addStock(stockSymbol);
            stockService.addStock(stockSymbol);
            return watchlistRepository.save(watchlist);
        }
        return null;
    }

    @Override
    public Watchlist removeStockFromWatchlist(String listName, String stockSymbol) {
        Watchlist watchlist = watchlistRepository.findByName(listName);
        if (watchlist != null) {
            watchlist.removeStock(stockSymbol);
            return watchlistRepository.save(watchlist);
        }
        return null;
    }
}
