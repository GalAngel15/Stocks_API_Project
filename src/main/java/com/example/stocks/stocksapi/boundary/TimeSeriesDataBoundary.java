package com.example.stocks.stocksapi.boundary;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeSeriesDataBoundary {

    @JsonProperty("1. open")
    private double open;

    @JsonProperty("2. high")
    private double high;

    @JsonProperty("3. low")
    private double low;

    @JsonProperty("4. close")
    private double close=0.0;

    @JsonProperty("5. volume")
    private long volume;

}
