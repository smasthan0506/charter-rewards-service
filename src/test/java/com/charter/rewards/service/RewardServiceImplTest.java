package com.charter.rewards.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.charter.rewards.dto.CustomerRewardDto;
import com.charter.rewards.entity.Customer;
import com.charter.rewards.entity.Transaction;
import com.charter.rewards.exception.CustomerNotFoundException;
import com.charter.rewards.repository.CustomerRepository;
import com.charter.rewards.repository.TransactionRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RewardServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private RewardServiceImpl rewardService;

    @Test
    void testCustomerNotFound() {

        when(customerRepository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                CustomerNotFoundException.class,
                () -> rewardService.getCustomerRewards(999L));
    }

    @Test
    void testGetCustomerRewards() {

        Customer customer =
                new Customer(101L, "Masthan");

        List<Transaction> transactions =
                List.of(
                        new Transaction(
                                1L,
                                120.0,
                                LocalDate.of(2026, 5, 10),
                                customer));

        when(customerRepository.findById(101L))
                .thenReturn(Optional.of(customer));

        when(transactionRepository
                .findByCustomerCustomerIdAndTransactionDateBetween(
                        anyLong(),
                        any(),
                        any()))
                .thenReturn(transactions);

        CustomerRewardDto dto =
                rewardService.getCustomerRewards(101L);

        assertEquals(101L, dto.getCustomerId());
    }
    
    @Test
    void shouldThrowExceptionWhenCustomerNotFound() {

        when(customerRepository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                CustomerNotFoundException.class,
                () -> rewardService.getCustomerRewards(999L));
    }
}