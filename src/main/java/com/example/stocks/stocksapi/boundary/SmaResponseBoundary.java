package com.example.stocks.stocksapi.boundary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmaResponseBoundary {
    @JsonProperty("Technical Analysis: SMA")
    private Map<String, SmaBoundary> technicalAnalysis;

    @Override
    public String toString() {
        return "SmaResponseBoundary{" +
                "technicalAnalysis=" + technicalAnalysis +
                '}';
    }

}


