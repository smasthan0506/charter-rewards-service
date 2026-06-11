package com.charter.rewards.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.List;

import com.charter.rewards.entity.Transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository repository;

    @Test
    void testFindTransactions() {

        List<Transaction> transactions =
                repository
                        .findByCustomerCustomerIdAndTransactionDateBetween(
                                101L,
                                LocalDate.of(2026, 1, 1),
                                LocalDate.of(2026, 12, 31));

        assertFalse(transactions.isEmpty());
    }
}