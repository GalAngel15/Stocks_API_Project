package dev.galAngel.stocks.stocksapi.boundary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TechIndicatorsBoundary {
    private String function;
    private String symbol;
    private String interval;
    private int time_period;
    private String series_type;

}
