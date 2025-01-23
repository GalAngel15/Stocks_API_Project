package dev.galAngel.stocks.stocksapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile("dev")
public class ConfigLogger {
    @Value("${server.port}")
    private int port;
    @Value("${spring.data.mongodb.uri}")
    private String host;
    @Value("${spring.data.mongodb.database}")
    private String database;


    @PostConstruct
    public void logProperties() {
        System.out.println("Server Port: " + port);
        System.out.println("MongoDB Host: " + host);
        System.out.println("MongoDB Database: " + database);
    }
}
