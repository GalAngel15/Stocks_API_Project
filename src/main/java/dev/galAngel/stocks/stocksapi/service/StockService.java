package dev.galAngel.stocks.stocksapi.service;

import dev.galAngel.stocks.stocksapi.boundary.GlobalQuoteResponse;
import dev.galAngel.stocks.stocksapi.boundary.IntradayDataPoint;
import dev.galAngel.stocks.stocksapi.boundary.SmaBoundary;
import dev.galAngel.stocks.stocksapi.boundary.TechIndicatorsBoundary;

import java.util.List;

public interface StockService {
    GlobalQuoteResponse.GlobalQuote getStockQuote(String symbol);

    List<IntradayDataPoint> getIntraday(String symbol, String interval);

    List<IntradayDataPoint> getTimeSeries(String function, String symbol);

    List<SmaBoundary> getIndicator(TechIndicatorsBoundary params);
}
