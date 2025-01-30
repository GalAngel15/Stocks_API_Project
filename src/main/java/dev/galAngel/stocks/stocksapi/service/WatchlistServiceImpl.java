package dev.galAngel.stocks.stocksapi.service;

import dev.galAngel.stocks.stocksapi.boundary.StockBoundary;
import dev.galAngel.stocks.stocksapi.boundary.WatchlistBoundary;
import dev.galAngel.stocks.stocksapi.entity.StockEntity;
import dev.galAngel.stocks.stocksapi.entity.Watchlist;
import dev.galAngel.stocks.stocksapi.repository.StockRepository;
import dev.galAngel.stocks.stocksapi.repository.WatchlistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public WatchlistBoundary getWatchlistByName(String name) {
        Watchlist wl= watchlistRepository.findByName(name);
        if(wl==null)
            return null;
        return WatchlistToWatchlistBoundary(wl);
    }

    @Override
    public void deleteWatchlist(String name) {
        watchlistRepository.deleteByName(name);
    }

    @Override
    public WatchlistBoundary addStockToWatchlist(String listName, String stockSymbol) {
        Watchlist watchlist = watchlistRepository.findByName(listName);
        if (watchlist != null) {
            watchlist.addStock(stockSymbol);
            stockService.addStock(stockSymbol);
            return WatchlistToWatchlistBoundary(watchlistRepository.save(watchlist));
        }
        throw new RuntimeException("Watchlist not found");
    }

    @Override
    public WatchlistBoundary removeStockFromWatchlist(String listName, String stockSymbol) {
        Watchlist watchlist = watchlistRepository.findByName(listName);
        if (watchlist != null) {
            watchlist.removeStock(stockSymbol);
            return WatchlistToWatchlistBoundary(watchlistRepository.save(watchlist));
        }
        return null;
    }

    public WatchlistBoundary WatchlistToWatchlistBoundary(Watchlist watchlist){
        List<StockBoundary> stocks=new ArrayList<>();
        for(String stockSymbol:watchlist.getStockSymbols()){
            stocks.add(stockService.getStockBySymbol(stockSymbol));
        }
        return new WatchlistBoundary(watchlist.getName(),stocks);
    }
}
