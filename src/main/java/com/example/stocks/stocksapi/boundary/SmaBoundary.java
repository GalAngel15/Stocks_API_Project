package com.example.stocks.stocksapi.boundary;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmaBoundary {
    private String date;

    @JsonProperty("SMA")
    private double sma;

    @Override
    public String toString() {
        return "SmaBoundary{" +
                "date='" + date + '\'' +
                ", SMA=" + sma +
                '}';
    }
}
