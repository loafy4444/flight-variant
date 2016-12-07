package com.cooksys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FlightVariantApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightVariantApplication.class, args);
	}
}
