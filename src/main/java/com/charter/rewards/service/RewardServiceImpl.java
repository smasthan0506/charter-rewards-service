package com.charter.rewards.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


/**
 * Implementation of RewardService.
 * Calculates monthly and total reward points
 * based on customer transactions.
 */
@Service
public class RewardServiceImpl implements RewardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RewardServiceImpl.class);
	
	private static final String CUSTOMER_NOT_FOUND = "Customer not found : ";
	private final CustomerRepository customerRepository;
	private final TransactionRepository transactionRepository;

	@Value("${reward.months}")
	private int rewardMonths;

	public RewardServiceImpl(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
		this.customerRepository = customerRepository;
		this.transactionRepository = transactionRepository;
	}

	
	/**Return reward details for the 
	 * specified customer.
	 * @param customerId the ID of the customer
	 * @return CustomerRewardDto containing reward details
	 */
	@Override
	public CustomerRewardDto getCustomerRewards(Long customerId) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException(CUSTOMER_NOT_FOUND + customerId));
		
		LOGGER.info("Calculating rewards for customer ID: {}", customerId);
		LocalDate endDate = LocalDate.now();
		LocalDate startDate = endDate.minusMonths(rewardMonths);
		LOGGER.info("Calculating rewards from {} to {}", startDate, endDate);
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

	/**Return reward details for the 
	 * specified customer.
	 * @param customerId the ID of the customer
	 * @param reward information
	 */
	@Override
	public List<CustomerRewardDto> getAllCustomerRewards() {

		return customerRepository.findAll().stream().map(customer -> getCustomerRewards(customer.getCustomerId()))
				.collect(Collectors.toList());
	}
}