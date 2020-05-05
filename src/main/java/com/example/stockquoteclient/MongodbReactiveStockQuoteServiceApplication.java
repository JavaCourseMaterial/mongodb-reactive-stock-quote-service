package com.example.stockquoteclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class MongodbReactiveStockQuoteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbReactiveStockQuoteServiceApplication.class, args);
	}
}
