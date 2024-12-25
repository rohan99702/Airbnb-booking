package com.airbnb_booking;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirbnbBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirbnbBookingApplication.class, args);
	}
	@Bean
    public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
}
