package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByDescriptionIgnoreCase(String description);
    List<Transaction> findByVendorIgnoreCase(String vendor);
    List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate);
    List<Transaction> findByAmountGreaterThan(double amount);
    List<Transaction> findByAmountLessThan(double amount);
}
