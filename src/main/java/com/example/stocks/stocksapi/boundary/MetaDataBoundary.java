package com.example.stocks.stocksapi.boundary;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class MetaDataBoundary {

    @JsonProperty("1. Information")
    private String information;

    @JsonProperty("2. Symbol")
    private String symbol;

    @JsonProperty("3. Last Refreshed")
    private String lastRefreshed;

    @JsonProperty("4. Interval")
    private String interval;

    @JsonProperty("5. Output Size")
    private String outputSize;

    @JsonProperty("6. Time Zone")
    private String timeZone;

    public LocalDateTime getLastRefreshedAsDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(lastRefreshed, formatter);
    }
}
