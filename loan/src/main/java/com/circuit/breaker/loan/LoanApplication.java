package com.circuit.breaker.loan;

import com.circuit.breaker.loan.model.Loan;
import com.circuit.breaker.loan.repository.LoanRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class LoanApplication {

	private final LoanRepository loanRepository;

	public LoanApplication(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

	@PostConstruct
	public void setupData() {
		loanRepository.saveAll(Arrays.asList(
				Loan.builder().id(1).type("PERSONAL").amount(200000.0).interest(0.0).build(),
				Loan.builder().id(2).type("HOUSING").amount(6000000.0).interest(0.0).build(),
				Loan.builder().id(3).type("PERSONAL").amount(100000.0).interest(0.0).build()
		));
	}

}
