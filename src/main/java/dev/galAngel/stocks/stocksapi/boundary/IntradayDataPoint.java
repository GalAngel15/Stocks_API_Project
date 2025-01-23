package dev.galAngel.stocks.stocksapi.boundary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IntradayDataPoint {

    private String timestamp;
    private double open;
    private double high;
    private double low;
    private double close;
    private long volume;


}
