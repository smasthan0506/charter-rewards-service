package com.charter.rewards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.rewards.dto.CustomerRewardDto;
import com.charter.rewards.service.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST controller responsible for handling reward-related API requests.
 * Provides APIs to fetch rewards for a specific customer and 
 * to fetch rewards for all customers.
 */
@RestController
@RequestMapping("/api/rewards")
public class RewardController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RewardController.class);

	@Autowired
	private RewardService rewardService;

	/**
	 * API endpoint to get rewards for a specific customer.
	 *
	 * @param customerId the ID of the customer
	 * @return a CustomerRewardDto containing the rewards information for the specified customer
	 */
	@GetMapping("/{customerId}")
	public CustomerRewardDto getCustomerRewards(@PathVariable Long customerId) {
		LOGGER.info("Received request to get rewards for customer ID: {}", customerId);
		return rewardService.getCustomerRewards(customerId);
	}

	
	/**
	 * API endpoint to get rewards for all customers.
	 *
	 * @return a list of CustomerRewardDto containing the rewards information for all customers
	 */
	@GetMapping("/customers")
	public List<CustomerRewardDto> getAllCustomerRewards() {

		return rewardService.getAllCustomerRewards();
	}
}