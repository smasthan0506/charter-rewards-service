package com.charter.rewards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.charter.rewards.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
