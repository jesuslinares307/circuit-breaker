package com.circuit.breaker.loan.repository;

import com.circuit.breaker.loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    List<Loan> findByType(String type);
}
