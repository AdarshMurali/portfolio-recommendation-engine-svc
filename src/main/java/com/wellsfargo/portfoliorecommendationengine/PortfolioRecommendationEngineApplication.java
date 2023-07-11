package com.wellsfargo.portfoliorecommendationengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PortfolioRecommendationEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioRecommendationEngineApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
