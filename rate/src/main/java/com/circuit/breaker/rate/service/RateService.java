package com.circuit.breaker.rate.service;


import com.circuit.breaker.rate.model.Rate;
import com.circuit.breaker.rate.repository.RateRepository;
import org.springframework.stereotype.Service;

@Service
public class RateService {


    private final RateRepository repository;

    public RateService(RateRepository repository) {
        this.repository = repository;
    }

    public Rate getRateByType(String type) {
        return repository.findByType(type).orElseThrow(() -> new RuntimeException("Rate Not Found: " + type));
    }
}
