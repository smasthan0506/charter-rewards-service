package com.charter.rewards.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.charter.rewards.dto.CustomerRewardDto;
import com.charter.rewards.dto.MonthlyRewardDto;
import com.charter.rewards.entity.Customer;
import com.charter.rewards.entity.Transaction;
import com.charter.rewards.exception.CustomerNotFoundException;
import com.charter.rewards.repository.CustomerRepository;
import com.charter.rewards.repository.TransactionRepository;
import com.charter.rewards.util.RewardCalculator;

@Service
public class RewardServiceImpl implements RewardService {

	private final CustomerRepository customerRepository;
	private final TransactionRepository transactionRepository;

	@Value("${reward.months}")
	private int rewardMonths;

	public RewardServiceImpl(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
		this.customerRepository = customerRepository;
		this.transactionRepository = transactionRepository;
	}

	@Override
	public CustomerRewardDto getCustomerRewards(Long customerId) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found : " + customerId));

		LocalDate endDate = LocalDate.now();
		LocalDate startDate = endDate.minusMonths(rewardMonths);

		List<Transaction> transactions = transactionRepository
				.findByCustomerCustomerIdAndTransactionDateBetween(customerId, startDate, endDate);

		Map<Month, Integer> monthlyRewards = transactions.stream().collect(Collectors.groupingBy(
				transaction -> transaction.getTransactionDate().getMonth(),
				Collectors.summingInt(transaction -> RewardCalculator.calculateRewardPoints(transaction.getAmount()))));

		List<MonthlyRewardDto> monthlyRewardDtos = new ArrayList<>();

		monthlyRewards.forEach((month, points) -> monthlyRewardDtos.add(new MonthlyRewardDto(month.name(), points)));

		int totalRewards = monthlyRewardDtos.stream().mapToInt(MonthlyRewardDto::getRewardPoints).sum();

		return new CustomerRewardDto(customer.getCustomerId(), customer.getCustomerName(), totalRewards,
				monthlyRewardDtos);

	}

	@Override
	public List<CustomerRewardDto> getAllCustomerRewards() {

		return customerRepository.findAll().stream().map(customer -> getCustomerRewards(customer.getCustomerId()))
				.collect(Collectors.toList());
	}
}