package com.airline.search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.airline.search.model.FlightBooking;

@Configuration
public class SearchConfig {
	@Bean
	public RestTemplate restemplate() {
		return new RestTemplate();
	}

	/*
	 * @Bean public FlightBooking flightBooking() { return new FlightBooking(); }
	 */
}
