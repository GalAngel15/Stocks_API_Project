package com.example.stocks.stocksapi.boundary;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class IntradayResponseBoundary {

    @JsonProperty("Meta Data")
    private MetaDataBoundary metaData;

    @JsonProperty("Time Series")
    private Map<String, Map<String, TimeSeriesDataBoundary>> timeSeries = new HashMap<>();

    @JsonAnySetter
    public void setTimeSeries(String key, Map<String, TimeSeriesDataBoundary> value) {
        if (key.contains("Time Series")) {
            timeSeries.put(key, value);
        }
    }

}
