package com.circuit.breaker.rate;

import com.circuit.breaker.rate.model.Rate;
import com.circuit.breaker.rate.repository.RateRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class RateApplication {

	private final RateRepository rateRepository;

	public RateApplication(RateRepository rateRepository) {
		this.rateRepository = rateRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RateApplication.class, args);
	}


	@PostConstruct
	public void setupData() {
		rateRepository.saveAll(Arrays.asList(
				Rate.builder().id(1).type("PERSONAL").rateValue(10.0).build(),
				Rate.builder().id(2).type("HOUSING").rateValue(8.0).build()
		));
	}
}
